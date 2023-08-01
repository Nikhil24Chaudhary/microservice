import { Component } from '@angular/core';
import { CandidateServiceService } from 'src/candidate-service.service';
import { AgGridModule } from 'ag-grid-angular';

@Component({
  selector: 'candidate-profile',
  templateUrl: './candidate-profile.component.html',
  styleUrls: ['./candidate-profile.component.css']
})
export class CandidateProfileComponent {
  columnDefs: any[] = [];
  rowData: any[] = [];
  constructor(private candidateService : CandidateServiceService){
this.columnDefs = [
      {headerName: 'Make', field: 'make' },
      {headerName: 'Model', field: 'model' },
      {headerName: 'Price', field: 'price'}
  ];

   this.rowData = [
      { make: 'Toyota', model: 'Celica', price: 35000 },
      { make: 'Ford', model: 'Mondeo', price: 32000 },
      { make: 'Porsche', model: 'Boxter', price: 72000 }
  ];
  }
  ngOnInit() {
    console.log("this.candidateService.showTasks");
  }

  title = 'app';

 

}
