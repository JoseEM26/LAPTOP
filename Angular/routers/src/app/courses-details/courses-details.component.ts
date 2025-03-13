import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-courses-details',
  imports: [],
  templateUrl: './courses-details.component.html',
  styleUrl: './courses-details.component.css'
})
export class CoursesDetailsComponent {

  course? : string ;

constructor(private route:ActivatedRoute){
  this.route.params.subscribe(params=>this.course=params['course'])
}
}
