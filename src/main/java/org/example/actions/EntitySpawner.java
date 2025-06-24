package org.example.actions;

import org.example.SimulationMap;
import org.example.entities.Entity;
import org.example.entities.Grass;

import java.util.List;

public class EntitySpawner {
    public void checkAndAddEntities(SimulationMap simulationMap) {

        int mapArea = simulationMap.rowCount() * simulationMap.columnCount();


        List<Entity> grass = simulationMap.getEntityByType(Grass.class);
        if (mapArea / grass.size() < 10) {

        }


    }
}
