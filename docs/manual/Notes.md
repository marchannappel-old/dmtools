# Notes

- Campaign Relationships
  - Missing ManyToMany for **Article**
  - Missing ManyToMany for **Character**
  - Missing ManyToMany for **NPC**
  - Missing ManyToMany for **Session**
- Session Relationships
  - Missing ManyToMany for **Plot**
  - Missing ManyToMany(mappedby) to Campaign
- Plot Relationships
  - Missing ManyToMany(mappedby) to Session
- Article
  - Missing ManyToMany(mappedby) to Campaign
- Character
  - Missing ManyToMany(mappedby) to Campaign
  - Missing OneToOne to Background
- NPC
  - Missing ManyToMany(mappedby) to Campaign
  - Missing ManyToMany(mappedby) to Encounter
  - Missing OneToOne to Background