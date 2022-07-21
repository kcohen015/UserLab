import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  LoginForm = new FormGroup({
    userName: new FormControl('', [Validators.required, Validators.minLength(6), Validators.pattern('/^[a-zA-Z0-9]+$/')]),
    passWord: new FormControl('', [Validators.required, Validators.minLength(6), Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{6,10}$')])
  })

  onSubmit() {
    console.log(this.LoginForm.value);
    alert("submit pressed");
    return true;
  }

  get userName() {
    return this.LoginForm.get('userName');
  }
  get passWord() {
    return this.LoginForm.get('passWord');
  }
}
