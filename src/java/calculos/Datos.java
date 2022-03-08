/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculos;

/**
 *
 * @author salva
 */
public class Datos {

    public Datos(String b, String h) {
        this.setBase(Double.parseDouble(b));
        this.setAltura(Double.parseDouble(h));
    }

    public void darArea() {
        double a_ = (this.getBase() * this.getAltura()) / 2;
        this.setArea(a_);
    }

    public void darPerimetro() {
        double p_ = (3 * this.getBase());
        this.setPerimetro(p_);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    private double base;
    private double altura;
    private double area;
    private double perimetro;

}
