import { Component, OnInit } from '@angular/core';
import {AddDependant} from '../classes/add-dependant';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-dependant',
  templateUrl: './add-dependant.component.html',
  styleUrls: ['./add-dependant.component.css']
})
export class AddDependantComponent {

  constructor(private http: HttpClient,private route: Router) { }

  addDependantData = new AddDependant("","","",new Date,"",0)

  onAddDependant()
  {
  let url = "http://localhost:8080/addEmployeeDependants"
  this.http.post(url,this.addDependantData).subscribe(
{
  next: res=>{
    location.reload();
  }
}
);

//this.route.navigate(['/addEmployee'])

  }


  ngOnInit(): void {
  }

}
