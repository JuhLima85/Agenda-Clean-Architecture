export class Contato{
    
    id: number;
    nome: string;
    email: string;
    favorito: boolean = false;
    foto: any;

    constructor(id: number, nome: string, email: string) {        
            this.id = id;
            this.nome = nome;
            this.email = email;
    }    
}