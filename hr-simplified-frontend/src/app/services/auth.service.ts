import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  auth(){
    return localStorage.getItem("authorize")
  }

  login() {
    localStorage.setItem("authorize", "true")
  }

  logout() {
    localStorage.removeItem("authorize")
  }
}
