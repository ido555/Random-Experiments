import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './components/main/main.component';
import { ChartComponent } from './components/chart/chart.component';
import { ChartModule } from '@syncfusion/ej2-angular-charts';
import { CategoryService, CandleSeriesService, TooltipService } from '@syncfusion/ej2-angular-charts';
import { LegendService, ZoomService } from '@syncfusion/ej2-angular-charts';
import { HttpClientModule } from '@angular/common/http'


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    ChartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ChartModule,
    HttpClientModule
  ],

  providers: [CategoryService, CandleSeriesService, TooltipService,  LegendService, ZoomService],
  bootstrap: [AppComponent]
})
export class AppModule { }
