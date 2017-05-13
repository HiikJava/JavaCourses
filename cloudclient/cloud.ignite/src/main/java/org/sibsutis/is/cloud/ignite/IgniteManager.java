/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package org.sibsutis.is.cloud.ignite;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CachePeekMode;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.transactions.Transaction;
import static org.apache.ignite.transactions.TransactionConcurrency.PESSIMISTIC;
import static org.apache.ignite.transactions.TransactionIsolation.REPEATABLE_READ;
import org.sibsutis.is.database.all.Man;

/**

 @author vaganovdv
 */
public class IgniteManager implements IgniteManagerAPI
{
    private static final Logger log = Logger.getLogger(IgniteManager.class.getName());
    private static Ignite ignite;

    @Override
    public boolean start()
    {
        boolean result = false;
        

        IgniteConfiguration cfg = new IgniteConfiguration();
        //CacheStorageConfiguration csc = new CacheStorageConfiguration(cfg);
        cfg.setClientMode(true);
        
        log.log(Level.INFO, "[IgniteManager] Конфигурация {Ignite} создана");
        
        log.log(Level.INFO, "[IgniteManager] Старт...");
        ignite = Ignition.start();
        result = true;
        
        IgniteCache <Long, Man> cache = ignite.getOrCreateCache("man.model");

        log.log(Level.INFO, "[IgniteManager] Разамер базы кэша [man.model] --> {" + cache.sizeLong(CachePeekMode.PRIMARY) + "}");
        log.log(Level.INFO, "[IgniteManager] Размещение данных в кеше... ");
        Man man = new Man();
        
            try (Transaction tx = ignite.transactions().txStart(PESSIMISTIC, REPEATABLE_READ))
        {
            for (long i = 0; i < cache.sizeLong(CachePeekMode.PRIMARY); i++)
            {
                man = (Man) cache.get(i);
                man.setId(i);
                log.log(Level.INFO, "Размещено в кэше [id = " + i + "]" + " { " + man.getFullName() + " }");
            }
            tx.commit();
        }
           log.log(Level.INFO, "[IgniteManager] Размещение данных в кеше завершено ");
        
        
        
        
        log.log(Level.INFO, "[IgniteManager] Попытка чтения из кэша [man.model]...");
        // Контрольное чтение
        
        try (Transaction tx = ignite.transactions().txStart(PESSIMISTIC, REPEATABLE_READ))
        {
            for (long i = 0; i < cache.sizeLong(CachePeekMode.PRIMARY); i++)
            {
                man = (Man) cache.get(i);
                log.log(Level.INFO, "Получено из кэша [id = " + i + "]" + " { " + man.getFullName() + " }");
            }
            tx.commit();
        }
        log.log(Level.INFO, "[IgniteManager] Стартовал");
        return result;
    }

    @Override
    public boolean stop()
    {
        boolean result = false;
        log.log(Level.INFO, "[IgniteManager] Остановка");

        try
        {
            if (ignite != null)
            {
                ignite.close();
                result = true;
                log.log(Level.INFO, "[IgniteManager] Остановлен");
            }
            else
            {
                result = false;
                log.log(Level.WARNING, "[IgniteManager] Экземпляр класса не существует - остановка невозможна");
            }
        }
        catch (IgniteException ex)
        {
            log.log(Level.WARNING, "[IgniteManager] Ошибка остановки модуля ");
            log.log(Level.WARNING, "[IgniteManager] Описание ошибки: [" + ex.toString() + "]");
        }
        return result;
    }
    
}
