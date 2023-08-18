
![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)

# DM Tools

The DM Tools are a web application that help dungeon masters to manager their games and worlds digitaly.

## Badges

## Features

- Authentication
- World Management (CMS Style)
- Character Creation
- NPC Creation
  - Generator
- Campaign Creation
- Session Creation
  - Dice Roller
    - Die Roll (d4, d6, d8, d10, d12, d20)
    - Combat Roll
    - Ability Roll
    - Saving Roll
    - Spell Roll
  - Simulations
    - Combat
    - Ability Checks
    - Save Checks
    - Spell Checks
  - Environment Controls (Time + Weather)
  - Session Logs
  - Notes
  - Player Management
    - Hit Points
    - Experience
    - Rewards
    - Ability Points
    - Initiative
    - Inventories
- Plot Creation
  - Encounter Creation
  - Encounter Generator
  - Quest Creation
  - Quest Generator
  - Location Creation
  - Location Generator
  - Shop Creation
  - Shop Generator
- Item Creation
  - Item Generation

## Demo

Insert gif or link to demo

## Roadmap

- [ ]  **Release 1.0.0**:
  - [X]  World Creation:
    - [X]  Data Model World
    - [X]  CRUDL World
    - [X]  Data Model Article
    - [X]  CRUDL Article
    - [X]  Data Model Article Type
    - [X]  CRUDL ArticleType
    - [X]  Data Model Category
    - [X]  CRUDL Category
  - [ ]  Campaign Creation:
    - [X]  Monsters:
      - [X]  Data Model Monster
      - [X]  CRUDL Monster
      - [X]  Data Model Action
      - [X]  CRUDL Action
      - [X]  Data Model Difficulty
      - [X]  CRUDL Difficulty
      - [X]  Data Model Sense
      - [X]  CRUDL Sense
    - [X]  Encounters:
      - [X]  Data Model Encounter
      - [X]  CRUDL Encounter
      - [X]  Data Model Consequence
      - [X]  CRUDL Consequence
      - [X]  Data Model Obstacle
      - [X]  CRUDL Obstacle
      - [X]  Data Model Tactic
      - [X]  CRUDL Tactic
    - [X]  Plots:
      - [X]  Data Model Plot
      - [X]  CRUDL Plot
      - [X]  Data Model Plot Type
      - [X]  CRUDL Plot Type
      - [X]  Data Model Theme
      - [X]  CRUDL Theme
    - [ ]  Sessions:
      - [ ]  Data Model Session
      - [ ]  CRUDL Session
      - [ ]  Data Model SessionLog
      - [ ]  CRUDL SessionLog
      - [ ]  Data Model LogEntry
      - [ ]  CRUDL LogEntry
      - [ ]  Data Model Note
      - [ ]  CRUDL Note
    - [ ]  Campaigns:
      - [ ]  Data Model Campaign
      - [ ]  CRUDL Campaign
  - [ ]  Character Creation:
    - [ ]  Characters:
      - [ ]  Data Model Character
      - [ ]  CRUDL Character
      - [ ]  Data Model NPC
      - [ ]  CRUDL NPC
      - [ ]  Data Model Character Type
      - [ ]  CRUDL Character Type
      - [ ]  Data Model Alignment
      - [ ]  CRUDL Alignment
      - [ ]  Data Model Ability
      - [ ]  CRUDL Ability
      - [ ]  Data Model Background
      - [ ]  CRUDL Background
      - [ ]  Data Model Class
      - [ ]  CRUDL Class
      - [ ]  Data Model Condition
      - [ ]  CRUDL Condition
      - [ ]  Data Model Defense
      - [ ]  CRUDL Defense
      - [ ]  Data Model Equipment
      - [ ]  CRUDL Equipment
      - [ ]  Data Model Feature
      - [ ]  CRUDL Feature
      - [ ]  Data Model Inventory
      - [ ]  CRUDL Inventory
      - [ ]  Data Model Language
      - [ ]  CRUDL Language
      - [ ]  Data Model Lifestyle
      - [ ]  CRUDL Lifestyle
      - [ ]  Data Model Proficiency
      - [ ]  CRUDL Proficiency
      - [ ]  Data Model Race
      - [ ]  CRUDL Race
      - [ ]  Data Model Skill
      - [ ]  CRUDL Skill
    - [ ]  Items:
      - [ ]  Data Model Item
      - [ ]  CRUDL Item
      - [ ]  Data Model Item Type
      - [ ]  CRUDL Item Type
      - [ ]  Data Model Item Category
      - [ ]  CRUDL Item Category
- [ ]  **Release 1.1.0**:
  - [ ]  Campaign Creation:
    - [ ]  Encounters:
      - [ ]  Generate Encounters
    - [ ]  Monsters:
      - [ ]  Generate Monsters
      - [ ]  Generate Loot
    - [ ]  Plots:
      - [ ]  Data Model Quests
      - [ ]  CRUDL Quests
      - [ ]  Generate Quests
      - [ ]  Data Model Location
      - [ ]  CRUDL Location
      - [ ]  Generate Location
      - [ ]  Data Model Shop
      - [ ]  CRUDL Shop
      - [ ]  Generate Shop
    - [ ]  Sessions:
      - [ ]  Manage Players
      - [ ]  Manage Experience
      - [ ]  Manage Hit Points
      - [ ]  Manage Abilities
      - [ ]  Manage Initiative
      - [ ]  Manage Inventories
      - [ ]  Simulations
      - [ ]  Roll Dice
      - [ ]  Manage Environment (Weather & Time)
  - [ ]  Character Creation:
    - [ ]  Characters:
      - [ ]  Generate Character Names
      - [ ]  Generate NPC's
    - [ ]  Items:
      - [ ]  Generate Items
- [ ]  **Release 1.2.0**:
  - [ ]  Frontend:
    - [ ]  Landing Page
    - [ ]  Dashboard Page
      - [ ]  Article Count Component
      - [ ]  Dashboard Actions Component
      - [ ]  Hierarchy Component
    - [ ]  View World Page
    - [ ]  Article Page
    - [ ]  Maps Page
    - [ ]  Image Page
    - [ ]  Campaign Page


## Documentation

[Documentation](https://linktodocumentation)

## Tech Stack

**Client:**

- Base:
  - React
  - Axios
  - React-Router
  - Styled Components
  - SCSS
  - Typescript
  - React-OIDC-Context
  - OIDC-Client-TS
- Utilities:
  - Lodash
- Testing:
  - Jest
  - Cypress
  - Mockito
  - Faker

**Server:**

- Base:
  - Java 20
  - Spring Boot 2.7.4
  - Spring Web
  - Spring Security
  - Hibernate
  - Spring Data JPA
  - MariaDB JDBC
- Utilities:
  - Lombok
- Testing:
  - JUnit
  - Mockito
  - Gatling

## Run Locally

### Docker

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```

Start Docker Containers
*

```bash
  docker-compose up
```

## Running Tests

### Frontend

To run tests, run the following command

```bash
  npm run test
```

### Backend

To run tests, run the following command

```bash
  mvn run test
```

## FAQ

### Question 1

Answer 1

### Question 2

Answer 2

## License

[MIT](https://choosealicense.com/licenses/mit/)

## Support

For support, email <fake@fake.com> or join our Slack channel.
