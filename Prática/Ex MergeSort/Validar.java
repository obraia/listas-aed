class Validar{

    public static boolean id(Produto[] produtos, int id) {

        if(id <= 0) {
            Console.Clear();
            System.out.println("Insira um valor não negativo \n");
            return false;
        }

        try {
            for (Produto produto : produtos) {
                if (produto.getId() == id) {
                    Console.Clear();
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
            Console.Clear();
            System.out.println("Preço inválido, digite um valor não negativo \n");
            return false;
        }
    }

}