class Console{
    public static void Sleep(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
        }
    }

    public static void Clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}