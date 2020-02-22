package com.learnings.practise.designpatterns;

import static com.learnings.practise.designpatterns.ShapeType.*;

public class AbstractFactory {
    public static void main(String[] args) {
         AbstractShapeFactory shapeFactory = ShapeFactory.getFactory(true);
         shapeFactory.getShape(SPHERE).paint();
         shapeFactory.getShape(CIRCLE).paint();

        shapeFactory = ShapeFactory.getFactory(false);
        shapeFactory.getShape(SQUARE).paint();
        shapeFactory.getShape(RECTANGLE).paint();
    }
}

enum ShapeType { CIRCLE, SPHERE, SQUARE, RECTANGLE }

interface Shape { void paint(); }

class Circle implements Shape { @Override public void paint() { System.out.println("Painting Circle."); } }
class Sphere implements Shape { @Override public void paint() { System.out.println("Painting Sphere."); } }
class Square implements Shape { @Override public void paint() { System.out.println("Painting Square."); } }
class Rectangle implements Shape { @Override public void paint() { System.out.println("Painting Rectangle."); } }

abstract class AbstractShapeFactory {
    abstract Shape getShape(ShapeType type);
}

class RoundedShapeFactory extends AbstractShapeFactory {
    @Override Shape getShape(ShapeType type) { return type.equals(SPHERE) ? new Sphere() : new Circle(); }
}

class NonRoundedShapeFactory extends AbstractShapeFactory {
    @Override Shape getShape(ShapeType type) { return type.equals(RECTANGLE) ? new Rectangle() : new Square(); }
}

class ShapeFactory {
    public static AbstractShapeFactory getFactory(boolean isRounded) {
        return isRounded ? new RoundedShapeFactory() : new NonRoundedShapeFactory();
    }
}