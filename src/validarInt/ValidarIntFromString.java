package validarInt;

public abstract class ValidarIntFromString {
    public static int validarIntFromString(String entradaString){
        if (entradaString.matches("\\d+")){
            return Integer.parseInt(entradaString);
        }else return -1;
    }
}
