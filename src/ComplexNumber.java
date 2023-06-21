import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ComplexNumber {
    private double real;        // Private field to store the real part of the complex number
    private double imaginary;   // Private field to store the imaginary part of the complex number
    // Constructor to initialize the complex number with given real and imaginary parts
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    // Getter method
    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }
    // Setter method
    public void setReal(double real) {
        this.real = real;
    }
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    // Method to add two complex numbers
    public ComplexNumber add(ComplexNumber other) {
        double realResult = this.real + other.real;
        double imaginaryResult = this.imaginary + other.imaginary;
        return new ComplexNumber(realResult, imaginaryResult);
    }
    // Method to subtract another complex number
    public ComplexNumber subtract(ComplexNumber other) {
        double realResult = this.real - other.real;
        double imaginaryResult = this.imaginary - other.imaginary;
        return new ComplexNumber(realResult, imaginaryResult);
    }
    // Method to multiply two complex numbers
    public ComplexNumber multiply(ComplexNumber other) {
        double realResult = (this.real * other.real) - (this.imaginary * other.imaginary);
        double imaginaryResult = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new ComplexNumber(realResult, imaginaryResult);
    }
    // Method to divide the complex number
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = Math.pow(other.real, 2) + Math.pow(other.imaginary, 2);
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        double realResult = ((this.real * other.real) + (this.imaginary * other.imaginary)) / denominator;
        double imaginaryResult = ((this.imaginary * other.real) - (this.real * other.imaginary)) / denominator;
        return new ComplexNumber(realResult, imaginaryResult);
    }
    public ComplexNumber power(int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative!");
        }
        double magnitude = Math.pow(getMagnitude(), exponent);
        double angle = getAngle() * exponent;
        double realResult = magnitude * Math.cos(angle);
        double imaginaryResult = magnitude * Math.sin(angle);
        return new ComplexNumber(realResult, imaginaryResult);
    }
    // Method to raise the current complex number to a power (exponent) and return the result as a new complex number

    public ComplexNumber symmetrical() {
        return new ComplexNumber(-this.real, -this.imaginary);
    }
    // Method to compute the symmetrical (negation) of the current complex number and return the result as a new complex number

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }
    // Method to compute the conjugate of the current complex number and return the result as a new complex number

    public ComplexNumber inverse() {
        double denominator = Math.pow(this.real, 2) + Math.pow(this.imaginary, 2);
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        double realResult = this.real / denominator;
        double imaginaryResult = -this.imaginary / denominator;
        return new ComplexNumber(realResult, imaginaryResult);
    }
    // Method to compute the inverse of the current complex number and return the result as a new complex number

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }
    // Method to compute the magnitude (absolute value) of the complex number

    public double getAngle() {
        return Math.atan2(this.imaginary, this.real);
    }
    // Method to compute the angle (phase) of the complex number

    @Override
    public String toString() {
        String sign = (imaginary >= 0) ? "+" : "-";
        return real + " " + sign + " " + Math.abs(imaginary) + "i";
    }
    // Override the toString() method to provide a string representation of the complex number
}

