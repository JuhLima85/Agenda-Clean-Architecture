import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarContatoComponent } from './editar-contato/editar-contato.component';
import { ContatoComponent } from './contato/contato.component';

const routes: Routes = [
  { path: '', component: ContatoComponent }, 
  { path: 'editar-contato/:id', component: EditarContatoComponent } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
