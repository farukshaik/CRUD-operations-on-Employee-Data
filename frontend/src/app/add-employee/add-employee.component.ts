import { Component, OnInit } from '@angular/core';
import {AddEmployee} from '../classes/add-employee';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})

export class AddEmployeeComponent {

  
constructor(private http: HttpClient,private route: Router) { }


addEmployeeData = new AddEmployee("","","",new Date,new Date,"","","",new Date,"","","","")
//addEmployeeData = new AddEmployee("","")



onAddEmployee()
  {
    console.log(this.addEmployeeData)
    console.log("hi")
  let url = "http://localhost:8080/addEmployee"
  this.http.post(url,this.addEmployeeData).subscribe(
   
 res=> console.log(res),
 err=>console.log(err)

);

//this.route.navigate(['/addEmployee'])

  }

  ngOnInit() {
  }

}
