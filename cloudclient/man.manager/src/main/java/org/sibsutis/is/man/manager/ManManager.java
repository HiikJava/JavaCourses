/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.man.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.sibsutis.is.man.model.Man;

/**
 *
 * @author vaganovdv
 */
public class ManManager
{
    private final ConcurrentMap <Long,  Man > ManDatabase  = new ConcurrentHashMap < >();
    
}
