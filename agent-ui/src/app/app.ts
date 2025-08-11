import { Component } from '@angular/core';
import { ChatComponent } from './chat/chat';
@Component({
  selector: 'app-root',
  imports: [ ChatComponent ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'agent-ui';
}
