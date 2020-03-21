import java.util.Scanner;

class Validar {

    public static byte entradaByte(){
        Scanner sc = new Scanner(System.in);
        byte valor = 0;
        try{
            valor = sc.nextByte();
        }catch(Exception e){
            valor = Byte.MAX_VALUE;
        }
        return valor;
    }

    public static int entradaInt(){
        Scanner sc = new Scanner(System.in);
        int valor = 0;
        try{
            valor = sc.nextInt();
        }catch(Exception e){
            valor = Integer.MIN_VALUE;
        }
        return valor;
    }

    public static float entradaFloat(){
        Scanner sc = new Scanner(System.in);
        float valor = 0;
        try{
            valor = sc.nextFloat();
        }catch(Exception e){
            valor = Float.MIN_VALUE;
        }
        return valor;
    }

    public static boolean quantidade(int value){
        if(value > 0){
            return true;
        }else{
            Console.clear();
            System.out.println("Insira um valor válido para a quantidade \n");
            return false;
        }
    }

    public static boolean id(Produto[] produtos, int id) {

        if(id <= 0) {
            Console.clear();
            System.out.println("Insira um valor válido para o código \n");
            return false;
        }

        try {
            for (Produto produto : produtos) {
                if (produto.getId() == id) {
                    Console.clear();
                    System.out.println("Id já cadastrado, escolha outro \n");
                    return false;
                }
            }
        } catch (Exception e) { }

        return true;
    }

    public static boolean preco(float preco){
        if(preco > 0) {
            return true;
        }
        else{
            Console.clear();
            System.out.println("Insira um valor válido para o preço \n");
            return false;
        }
    }

}