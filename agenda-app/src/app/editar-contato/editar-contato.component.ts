import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Contato } from '../contato/contato';
import { ContatoService } from '../contato.service';

@Component({
  selector: 'app-editar-contato',
  templateUrl: './editar-contato.component.html',
  styleUrls: ['./editar-contato.component.css']
})
export class EditarContatoComponent implements OnInit {

  contatoForm: FormGroup = new FormGroup({}); 
  contato: Contato | null = null;  
  id: number = 0; 

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,    
    private contatoService: ContatoService
  ) { }

  ngOnInit(): void {   
    this.id = this.route.snapshot.params['id'];    
    this.carregarDetalhesContato();
    this.inicializarFormulario();
  }
  
  carregarDetalhesContato() {
    this.contatoService.getContatoById(this.id).subscribe((contato: Contato) => {
      this.contato = contato;
      this.atualizarFormulario();
    });
  }

  inicializarFormulario() {
    this.contatoForm = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  atualizarFormulario() {
    this.contatoForm.patchValue({
      nome: this.contato!.nome,
      email: this.contato!.email
    });
  }
  
  salvarAlteracoes() {    
    const formValues = this.contatoForm.value
    const contato = new Contato( 
      this.id, 
      formValues.nome, 
      formValues.email) 
    this.contatoService.updateContato(contato).subscribe(() => {      
      this.router.navigate(['/']);
    });
  }

  cancelarEdicao() {    
    this.router.navigate(['/']);
  } 

}
