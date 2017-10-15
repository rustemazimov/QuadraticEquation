package com.example.rustem.quadraticequation;

/**
 * Finds root(s) of the function for the given parameters
 * a, b, c . And stores them as instance variables
 * @author Rustem
 */

final class QuadraticEquationSolver {
    private double a;
    private double b;
    private double c;
    private double D;
    private double x1;
    private double x2;

    /**
     *
     * @param a
     *      a in the quadratic equation
     * @param b
     *      b in the quadratic equation
     * @param c
     *      c in the quadratic equation
     * @throws RootNotFoundException
     *      Custom exception for to inform the program about D < 0
     */
    QuadraticEquationSolver(double a, double b, double c) throws RootNotFoundException {
        //Initialize a, b, c
        this.a = a;
        this.b = b;
        this.c = c;
        //Calculate determinant
        calcD();
        if(this.D < 0) throw new RootNotFoundException();
        //Calculate roots of the function for the given parameters
        calcX1();
        calcX2();

    }

    /**
     * Methods for calculating Determinant, root(s) and storing them as instance variables
     */
    private void calcD(){
        this.D = b * b - 4 * a * c;
    }
    private void calcX1(){
        this.x1 = - (b + Math.sqrt(this.D)) / (2 * a);
    }
    private void calcX2(){
        this.x2 = - (b - Math.sqrt(this.D)) / (2 * a);
    }
    //Getters for roots of the function
    public double getX1(){
        return this.x1;
    }
    public double getX2(){
        return this.x2;
    }
}
