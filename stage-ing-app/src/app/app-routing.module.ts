import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StageIngComponent } from './components/stage-ing/stage-ing.component';

const routes: Routes = [
  { path: '', redirectTo: 'stage-ing', pathMatch: 'full' },
  { path: 'stage-ing', component: StageIngComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
