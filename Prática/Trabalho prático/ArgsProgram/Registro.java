class Registro {
    private int roomId;
    private int hostId;
    private String roomType;
    private String country;
    private String city;
    private String neighborhood;
    private float reviews;
    private float overallSatisfaction;
    private int accommodates;
    private int bedrooms;
    private float price;
    private String propertyType;

    public Registro(int roomId, int hostId, String roomType, String country, String city, String neighborhood,
            float reviews, float overallSatisfaction, int accommodates, int bedrooms, float price,
            String propertyType) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighborhood = neighborhood;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;
    }

    public boolean menorQue(Registro r, boolean crescente) {
        if (this.roomId < r.roomId) {
            return crescente;
        } else {
            return !crescente;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Room ID: %d - Host Id: %d - Room Type: %s - Country: %s - City: %s - Neighborhood: %s - Reviews: %.1f - Overall satisfaction: %.1f - Accommodates: %d - Bedrooms: %s - Price: %.2f - Property type: %s",
                this.roomId, this.hostId, this.roomType, this.country, this.city, this.neighborhood, this.reviews,
                this.overallSatisfaction, this.accommodates, this.bedrooms, this.price, this.propertyType);
    }

    public String toStringSummary() {
        return String.format(
                "ID: %d - País: %s - Cidade: %s - Avaliação: %.1f - Quartos: %s - Preço: $ %.2f - Tipo: %s",
                this.roomId, this.country, this.city, this.reviews, this.bedrooms, this.price, this.propertyType);
    }

    public static void ExibirRegistros(Registro registros[]) {
        for (Registro registro : registros) {
            System.out.println(registro);
        }
    }

    public static void ExibirResumo(Registro registros[]) {
        for (Registro registro : registros) {
            System.out.println(registro.toStringSummary());
        }
    }

}
