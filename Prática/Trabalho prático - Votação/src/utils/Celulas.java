package src.utils;

import src.models.*;

class CelulaCandidato {
    Candidato item;
    CelulaCandidato proximo;

    public CelulaCandidato() {
        this.item = new Candidato();
        this.proximo = null;
    }
}

class CelulaEleitor {
    Eleitor item;
    CelulaEleitor proximo;

    public CelulaEleitor() {
        this.item = new Eleitor();
        this.proximo = null;
    }
}

class CelulaMunicipio {
    Municipio item;
    CelulaMunicipio proximo;

    public CelulaMunicipio() {
        this.item = new Municipio();
        this.proximo = null;
    }
}

class CelulaPartido {
    Partido item;
    CelulaPartido proximo;

    public CelulaPartido() {
        this.item = new Partido();
        this.proximo = null;
    }
}

class CelulaUrna {
    Urna item;
    CelulaUrna proximo;

    public CelulaUrna(Urna urna) {
        this.item = new Urna();
        this.proximo = null;
    }
}
