-- populate_data.sql

-- Populate Player table
INSERT INTO player (name, email, username, experience) VALUES ('Alice Johnson', 'alice.johnson@example.com', 'AliceJ', 'Intermediate');
INSERT INTO player (name, email, username, experience) VALUES ('Bob Smith', 'bob.smith@example.com', 'BobS', 'Beginner');
INSERT INTO player (name, email, username, experience) VALUES ('Charlie Davis', 'charlie.davis@example.com', 'CharlieD', 'Expert');
INSERT INTO player (name, email, username, experience) VALUES ('Dana Lee', 'dana.lee@example.com', 'DanaL', 'Intermediate');
INSERT INTO player (name, email, username, experience) VALUES ('Evan Brown', 'evan.brown@example.com', 'EvanB', 'Beginner');
INSERT INTO player (name, email, username, experience) VALUES ('Fiona Green', ' fiona.green@example.com', 'FionaG', 'Expert');
INSERT INTO player (name, email, username, experience) VALUES ('George White', 'george.white@example.com', 'GeorgeW', 'Intermediate');
INSERT INTO player (name, email, username, experience) VALUES ('Hannah Black', 'hannah.black@example.com', 'HannahB', 'Beginner');
INSERT INTO player (name, email, username, experience) VALUES ('Ian Grey', 'ian.grey@example.com', 'IanG', 'Expert');
INSERT INTO player (name, email, username, experience) VALUES ('Julia Red', 'julia.red@example.com', 'JuliaR', 'Intermediate');


-- Populate Campaign table
INSERT INTO campaign (name, description, dungeon_master, status) VALUES ('Campaign 1', 'An epic adventure', 'Dungeon Master 1', 'Ongoing');
INSERT INTO campaign (name, description, dungeon_master, status) VALUES ('Campaign 2', 'A thrilling quest', 'Dungeon Master 2', 'Completed');

-- Populate Character table
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Aric Stormbringer', 'Human', 'Fighter', '5', 1, 1);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Elara Moonshadow', 'Elf', 'Wizard', '4', 2, 1);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Thorgar Stonefist', 'Dwarf', 'Barbarian', '3', 3, 1);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Lirael Windrunner', 'Half-Elf', 'Ranger', '3', 4, 1);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Borin Ironfoot', 'Dwarf', 'Cleric', '4', 5, 1);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Kira Swiftblade', 'Halfling', 'Rogue', '3', 6, 2);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Talia Starwhisper', 'Tiefling', 'Sorcerer', '4', 7, 2);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Garrick Darkwood', 'Human', 'Warlock', '3', 8, 2);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Seraphina Brightspark', 'Half-Elf', 'Bard', '4', 9, 2);
INSERT INTO character (name, race, character_class, character_level, player_id, campaign_id) VALUES ('Varis Nightbreeze', 'Elf', 'Druid', '3', 10, 2);


---- Populate Stats table (assuming character_id corresponds to the correct character)
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (18, 14, 16, 10, 12, 10, 1);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (8, 14, 12, 18, 13, 12, 2);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (16, 14, 18, 10, 12, 8, 3);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (12, 16, 14, 10, 14, 12, 4);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (14, 10, 16, 10, 18, 12, 5);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (10, 18, 12, 14, 10, 14, 6);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (8, 14, 14, 12, 10, 18, 7);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (10, 14, 12, 14, 12, 16, 8);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (10, 14, 12, 12, 10, 18, 9);
--INSERT INTO stats (strength, dexterity, constitution, intelligence, wisdom, charisma, character_id) VALUES (10, 14, 12, 12, 16, 10, 10);