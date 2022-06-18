import { ChoreService } from './../../services/chore.service';
import { Component, OnInit } from '@angular/core';
import { Chore } from 'src/app/models/chore';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  chores: Chore[] = [];

  newChore: Chore = new Chore();
  editChore: null | Chore = null;
  selected: null | Chore = null;
  addChoreButton: string = 'Add New Chore';
  choreButtonSelected: boolean = true;

  constructor(
    private choreService: ChoreService
  ) { }

  ngOnInit(): void {
    this.reload();
  }

  reload() {
    this.choreService.index().subscribe({
      next: (chores) => {this.chores = chores},
      error: (bad) => {
        console.error("ChoreComponent.reload: error loading list");
        console.error(bad);
      }
    });
  }

  displayChore(chore: Chore) {
    this.selected = chore;
  }

  displayTable() {
    this.selected = null;
  }

  addChoreButtonValue() {
    if (this.choreButtonSelected === true) {
      this.choreButtonSelected = false;
      return this.addChoreButton = 'Close';
    }
    else {
      this.choreButtonSelected = true;
      return this.addChoreButton = 'Add New Chore';
    }
  }

  addChore(chore: Chore) {
    this.choreService.create(chore).subscribe({
      next: (newChore) => {
        this.reload();
        this.newChore = new Chore();
      },
      error: (fail) => {
        console.error('ChoreListComponent.addChore: error adding chore');
        console.error(fail);
      },
    });
    this.choreButtonSelected = true;
  }

  setEditChore() {
    this.editChore = Object.assign({}, this.selected);
  }

  updateChore (chore: Chore, setSelected: boolean = true) {
    this.choreService.update(chore).subscribe({
      next: (updated) => {
        this.reload();
        if (setSelected) {
          this.selected = updated; // BACK TO DETAIL VIEW
          // this.selected = null; // BACK TO LIST
        }
        this.editChore = null;
      },
      error: (nojoy) => {
        console.error('ChoreListComponent.updateChore: error on update');
        console.error(nojoy);
      },
    });
  }

  deleteChore(id: number | null): void {
    if (id !== null) {
      this.choreService.destroy(id).subscribe({
        next: () => {
          this.selected = null;
          this.reload();
        },
        error: (fail) => {
          console.error('TodoListComponent.delete: error on delete');
          console.error(fail);
        },
      });
    }
  }
}

function err(err: any) {
  throw new Error('Function not implemented.');
}

