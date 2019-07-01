import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidenavMainContentComponent } from './sidenav-main-content.component';

describe('SidenavMainContentComponent', () => {
  let component: SidenavMainContentComponent;
  let fixture: ComponentFixture<SidenavMainContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidenavMainContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidenavMainContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
