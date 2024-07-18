-- init.sql

-- Create Player table
CREATE TABLE player (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    experience VARCHAR(255)
);

-- Create Campaign table
CREATE TABLE campaign (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    dungeon_master VARCHAR(255),
    status VARCHAR(255)
);

-- Create Character table
CREATE TABLE character (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    race VARCHAR(255),
    character_class VARCHAR(255),
    character_level VARCHAR(255),
    player_id INTEGER NOT NULL,
    campaign_id INTEGER,
    CONSTRAINT fk_player FOREIGN KEY (player_id) REFERENCES player(id),
    CONSTRAINT fk_campaign FOREIGN KEY (campaign_id) REFERENCES campaign(id)
);

-- Create Stats table
CREATE TABLE stats (
    id SERIAL PRIMARY KEY,
    strength INTEGER,
    dexterity INTEGER,
    constitution INTEGER,
    intelligence INTEGER,
    wisdom INTEGER,
    charisma INTEGER,
    character_id INTEGER NOT NULL,
    CONSTRAINT fk_character FOREIGN KEY (character_id) REFERENCES character(id)
);