import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Component, OnInit, Inject } from '@angular/core';

@Component({
  selector: 'app-client-info-popup',
  templateUrl: './client-info-popup.component.html',
  styleUrls: ['./client-info-popup.component.css']
})
export class ClientInfoPopupComponent implements OnInit {

  client;

  constructor(private dialogRef:MatDialogRef<ClientInfoPopupComponent>, @Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit(): void {
    this.client = this.data.client
  }

  closeDialog(){
    this.dialogRef.close()
  }

}
