import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { ClientType } from 'src/app/enums/client-type.enum';

@Component({
  selector: 'app-client-info-popup',
  templateUrl: './client-info-popup.component.html',
  styleUrls: ['./client-info-popup.component.css']
})
export class ClientInfoPopupComponent implements OnInit {

  client;
  clientType: ClientType;

  constructor(private dialogRef:MatDialogRef<ClientInfoPopupComponent>, @Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit(): void {
    this.client = this.data.client
    if (this.client.companyId != null) 
      this.clientType = ClientType.Company  
    this.clientType = ClientType.Customer
  }

  closeDialog(){
    this.dialogRef.close()
  }

}
