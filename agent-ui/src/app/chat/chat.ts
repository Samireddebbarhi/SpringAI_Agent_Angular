import {Component} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpDownloadProgressEvent, HttpEventType} from '@angular/common/http';
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
  loading: boolean = false ;

constructor(private https: HttpClient) {}
  askAgent() {
  this.loading = true;
this.https.get(`http://localhost:8080/askAgent?query=${this.query}`,{responseType:"text" ,observe:"events", reportProgress:true})
    .subscribe({next : evt =>{
     if (evt.type === HttpEventType.DownloadProgress ) {
       this.response = (evt as HttpDownloadProgressEvent).partialText;
     }
     },
  error: error => console.log(error)
    ,
      complete : () => {
        this.loading = false;
      },
  })
  }
  }

