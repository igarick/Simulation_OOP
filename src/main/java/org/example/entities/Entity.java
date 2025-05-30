package org.example.entities;

public abstract class Entity {
    //Корневой абстрактный класс для всех существ и объектов
    // существующих в симуляции.

    private int coordinate;

    public Entity(int coordinate) {
        this.coordinate = coordinate;
    }

}
