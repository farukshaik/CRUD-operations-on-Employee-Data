import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddEmployeeComponent} from "./add-employee/add-employee.component"
import {AddDependantComponent} from "./add-dependant/add-dependant.component"
import {AppComponent} from "./app.component"

const routes: Routes = [
  
  {
  path: 'addEmployee', component: AddEmployeeComponent,
  },
  {
  path: 'addEmployeeDependants', component: AddDependantComponent
}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
