import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Contato } from './contato/contato';

import { environment } from '../environments/environment';
import { PaginaContato } from './contato/paginaContato';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {

  url: string = environment.apiBaseUrl;

  constructor(
    private http: HttpClient
  ) { }

  save(contato: Contato) : Observable<Contato>{
    return this.http.post<Contato>(this.url, contato);
  }

  list(page: number, size: number) : Observable<PaginaContato>{
    const params = new HttpParams().set('page', page).set('size',size)    
    return this.http.get<any>(`${this.url}?${params.toString()}`);
  }

  favourite(contato: Contato) : Observable<any> {
    return this.http.patch(`${this.url}/${contato.id}/favorito`, null);
  }

  upload(contato: Contato, formData: FormData) : Observable<any>{
    console.log("Entrou no service")
    return this.http.put(`${this.url}/${contato.id}/foto`, formData, { responseType : 'blob'});
  }
   
   delete(contato: Contato): Observable<any> {
    return this.http.delete(`${this.url}/${contato.id}`);
  }
  
  getContatoById(id: number): Observable<Contato> {
    return this.http.get<Contato>(`${this.url}/${id}`);
  }
  
  updateContato(contato: Contato): Observable<any> {
    return this.http.put(`${this.url}/${contato.id}`, contato);
  }
  
}
