import {Component, OnInit} from '@angular/core';
import {Company} from '../../../models/company';
import {MatDialogRef} from '@angular/material/dialog';
import {GlobalService} from '../../../services/global.service';
import {CompanyControllerService} from '../../../services/company-controller.service';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {
  // initialize comp because html interpolation starts too early and throws errors
  // just before getDetails() completes
  comp: Company = new Company(
    undefined, undefined, undefined, undefined);

  constructor(private dialogRef: MatDialogRef<CompanyDetailsComponent>, private glob: GlobalService,
              private cont: CompanyControllerService) {
  }

  ngOnInit(): void {
    this.getDetails();
  }

  initComp(comp) {
    this.comp = new Company(comp.companyId, comp.password, comp.name, comp.email);
  }

  getDetails() {
    this.cont.getDetails(this.glob.getToken()).subscribe(
      s => {
        this.initComp(s);
      },
      e => this.glob.errPopup(e.error));
  };

}
