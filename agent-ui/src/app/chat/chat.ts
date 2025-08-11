import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {MarkdownModule} from 'ngx-markdown';

@Component({
  selector: 'app-chat',
  imports: [CommonModule, FormsModule,MarkdownModule],
  templateUrl: './chat.html',
  styleUrl: './chat.css',
  standalone:true
})
export class ChatComponent {
  query: string = "";
  response: any;
  loading: any ;

constructor(private https: HttpClient) {}
  askAgent() {
this.https.get(`http://localhost:8080/askAgent?query=${this.query}`,{responseType:"text"})
    .subscribe({next : value =>{
      this.response = value;
      },
  error: error => console.log(error)})
  }

  }

