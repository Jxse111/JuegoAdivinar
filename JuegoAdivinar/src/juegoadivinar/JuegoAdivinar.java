/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoadivinar;

/**
 *
 * @author José
 */
public class JuegoAdivinar {

    //Atributos de clase publicos y constantes
    public static int LIMITE_MAX_VAL_POSIBLE = 40;
    public static int LIMITE_MAX_INTENTOS = 10;
    public static int DEFAULT_MAX_VAL_POSIBLE = 10;
    public static int DEFAULT_LIMITE_MAX_INTENTOS = 5;
    //Atributos de objeto
    private int numeroSecreto;
    private int intentosActuales;
    private final int maxValorPosible;
    private final int maxIntentos;
    //Constructor/es

    /**
     * Constructor al que se le pasan dos parametros.
     *
     * @param maxValorPosible el mayor valor posible.
     * @param maxIntentos el numero maximo de intentos.
     * @throws IllegalArgumentException si se sale del rango tanto el valor como
     * los intentos.
     */
    public JuegoAdivinar(int maxValorPosible, int maxIntentos) throws IllegalArgumentException {
        if (maxValorPosible <= 0 || maxValorPosible > LIMITE_MAX_VAL_POSIBLE) {
            throw new IllegalArgumentException(String.format("Límite de número secreto fuera de rango\n"));
        } else if (maxIntentos <= 0 || maxIntentos > LIMITE_MAX_INTENTOS) {
            throw new IllegalArgumentException(String.format("Límite de intentos fuera de rango\n"));
        }
        this.maxValorPosible = maxValorPosible;
        this.maxIntentos = maxIntentos;
        this.numeroSecreto = (int) Math.random() * 41;
    }

    /**
     * Constructor al que se le pasa un unico parametro el otro parametro se
     * devuelve de manera por defecto.
     *
     * @param maxIntentos el numero de intentos maximo
     * @throws IllegalArgumentException si se sale del rango, los intentos.
     */
    public JuegoAdivinar(int maxIntentos) throws IllegalArgumentException {
        this(DEFAULT_MAX_VAL_POSIBLE, maxIntentos);
    }

    /**
     * Constructor por defecto sin parametros.
     */
    public JuegoAdivinar() {
        this(DEFAULT_MAX_VAL_POSIBLE, DEFAULT_LIMITE_MAX_INTENTOS);
    }

    //Métodos getter y otros métodos
    /**
     * Método que devuelve los intentos restantes.
     *
     * @return los intentos restantes.
     */
    public int getIntentosRestantes() {
        int intentosRestantes = LIMITE_MAX_INTENTOS;
        intentosRestantes = intentosRestantes - this.intentosActuales;
        return intentosRestantes;
    }

    /**
     * Método que devuelve el mayor valor posible.
     *
     * @return el mayor valor posible.
     */
    public int getMaxValorPosible() {
        return this.maxValorPosible;
    }

    /**
     * Método que adivina el numero en base al numero que le devolvamos.
     *
     * @param numero el numero que introducimos por parametro.
     * @return el numero introducido.
     */
    public int adivinarNumero(int numero) {
        int numeroAdivinar = 0;
        if (numero < this.numeroSecreto) {
            numeroAdivinar = 1;
            this.intentosActuales++;
        } else if (numero > this.numeroSecreto) {
            numeroAdivinar = -1;
            this.intentosActuales++;
        } else if (numero == this.numeroSecreto) {
            numeroAdivinar = 0;
            this.intentosActuales++;
        }
        return numeroAdivinar;
    }
}
