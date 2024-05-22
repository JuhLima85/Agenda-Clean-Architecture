import { Component, OnInit } from '@angular/core';
import { Contato } from './contato';
import { ContatoService } from '../contato.service';

import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { MatDialog } from '@angular/material/dialog';

import { ContatoDetalheComponent } from '../contato-detalhe/contato-detalhe.component';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';


@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.css']
})

export class ContatoComponent implements OnInit{  
  
  formulario: FormGroup = new FormGroup({});
  contatos: Contato[] = [];
  colunas = ['id','foto', 'nome', 'email', 'favorito', 'excluir', 'editar']
  imagem: string | ArrayBuffer | null = null;

  totalElementos = 0;
  pagina = 0;
  tamanho = 5;
  pageSizeOptions : number[] = [5]

  constructor(
    private service: ContatoService,
    private fb: FormBuilder,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
    
  ){}

  ngOnInit(): void {    
    this.montarFormulario();
    this.listarContatos(this.pagina, this.tamanho);
  }

  montarFormulario(){
    this.formulario = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    })
  } 

  listarContatos(pagina: number = 0, tamanho: number = 5){
    this.service.list(pagina, tamanho).subscribe(response => {
      this.contatos = response.content;
      this.totalElementos = response.totalElements;
      this.pagina = response.number;
    })
  }

  favoritar(contato: Contato){
    this.service.favourite(contato).subscribe(response => {
      contato.favorito = !contato.favorito;
    })
  }

  submit(){
    const formValues = this.formulario.value
    const contato = new Contato(formValues.id, formValues.nome, formValues.email)
    this.service.save(contato).subscribe( resposta => {
      this.listarContatos()       
       this.snackBar.open('O Contato foi adicionado!', 'Sucesso', {
        duration: 2000
       })   
       this.formulario.reset(); 
      })
  }

  uploadFoto(event: Event, contato: Contato){
    console.log("entrou no uploadFoto")
    const files = (event.target as HTMLInputElement).files; 

    if(files && files.length > 0){
      console.log("Entrou no if do componente")
      const foto = files[0];      
      const formData: FormData = new FormData();
      formData.append("foto", foto);
      this.service
        .upload(contato, formData)
        .subscribe(response => this.listarContatos(this.pagina, this.tamanho));
    }
  }  

  vizualizarContato(contato: Contato) {
    this.dialog.open( ContatoDetalheComponent, {
      width: '500px',
      height: '550px',
      data: contato
    })
  }

  paginar(event: PageEvent){
    this.pagina = event.pageIndex;
    this.listarContatos(this.pagina, this.tamanho)
  }
  
  excluirContato(contato: Contato) {
    this.service.delete(contato).subscribe(() => {      
      this.listarContatos(this.pagina, this.tamanho);     
      this.snackBar.open('O Contato foi excluído!', 'Sucesso', {
        duration: 2000
      });
    }, error => {      
      this.snackBar.open('Erro ao excluir o Contato!', 'Erro', {
        duration: 2000
      });
    });
  }
  
  editarContato(contato: Contato) {        
    this.router.navigate(['/editar-contato', contato.id]);
  }

}
