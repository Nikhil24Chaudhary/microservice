import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CandidateProfileComponent } from './candidate-profile/candidate-profile.component';
import { CandidateServiceService } from 'src/candidate-service.service';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';
import { UserTabsComponent } from './user-tabs/user-tabs.component';
import { MatTabsModule } from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    CandidateProfileComponent,
    UserTabsComponent
  ],
  imports: [
    BrowserModule,
    AgGridModule,
    MatTabsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [CandidateServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
