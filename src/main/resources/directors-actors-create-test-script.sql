INSERT INTO directors (name)
    VALUE
    ('Denis Villeneuve'),
    ('James Wan'),
    ('Mike Flanagan'),
    ('Alex Garland'),
    ('Sam Mendes');


INSERT INTO movies (title, year, plot, poster, rating, director, director_id)
VALUES
    ('Dune', '2021', 'Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet''s exclusive supply of the most precious resource in existence, only those who can conquer their own fear will survive.',
     'poster','9', 'Denis Villeneuve', 1),
    ('Skyfall', '2012', 'When James Bond''s (Daniel Craig) latest assignment goes terribly wrong, it leads to a calamitous turn of events: Undercover agents around the world are exposed, and MI6 is attacked, forcing M (Judi Dench) to relocate the agency. With MI6 now compromised inside and out, M turns to the one man she can trust: Bond. Aided only by a field agent (Naomie Harris), Bond takes to the shadows and follows a trail to Silva (Javier Bardem), a man from M''s past who wants to settle an old score.',
     'poster','8', 'Sam Mendes', 5),
    ('Sicario', '2015', 'After rising through the ranks of her male-dominated profession, idealistic FBI agent Kate Macer (Emily Blunt) receives a top assignment. Recruited by mysterious government official Matt Graver (Josh Brolin), Kate joins a task force for the escalating war against drugs. Led by the intense and shadowy Alejandro (Benicio Del Toro), the team travels back-and-forth across the U.S.-Mexican border, using one cartel boss (Bernardo Saracino) to flush out a bigger one (Julio Cesar Cedillo).',
     'poster','7', 'Denis Villeneuve', 1),
    ('Ex Machina', '2014', 'Caleb Smith (Domhnall Gleeson) a programmer at a huge Internet company, wins a contest that enables him to spend a week at the private estate of Nathan Bateman (Oscar Isaac), his firm''s brilliant CEO. When he arrives, Caleb learns that he has been chosen to be the human component in a Turing test to determine the capabilities and consciousness of Ava (Alicia Vikander), a beautiful robot. However, it soon becomes evident that Ava is far more self-aware and deceptive than either man imagined.',
     'poster','7', 'Alex Garland', 4),
    ('Aquaman', '2018', 'Once home to the most advanced civilization on Earth, the city of Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people -- and then the surface world. Standing in his way is Aquaman, Orm''s half-human, half-Atlantean brother and true heir to the throne. With help from royal counselor Vulko, Aquaman must retrieve the legendary Trident of Atlan and embrace his destiny as protector of the deep.',
     'poster','6', 'James Wan', 2),
    ('Doctor Sleep', '2019', 'Struggling with alcoholism, Dan Torrance remains traumatized by the sinister events that occurred at the Overlook Hotel when he was a child. His hope for a peaceful existence soon becomes shattered when he meets Abra, a teen who shares his extrasensory gift of the "shine." Together, they form an unlikely alliance to battle the True Knot, a cult whose members try to feed off the shine of innocents to become immortal.',
     'poster','7', 'Mike Flanagan', 3);




INSERT INTO actors (name)
    VALUE ('Timothée Chalamet'),
    ('Zendaya'),
    ('Oscar Isaac'),
    ('Rebecca Ferguson'),
    ('Jason Momoa'),
    ('Josh Brolin'),
    ('Javier Bardem');

# *****USED TO MATCH GENRES AND MOVIES**************
INSERT INTO movie_genre (movie_id, genre_id)
VALUES
    (1,7),(1,1),(1,2),
    (6,4),(6,9),(6,5),
    (5,1),(5,4),(5,7),
    (4,7),(4,9),
    (3,9),(3,1),(3,2),
    (2,1),(2,9),(2,2);



# *****USED TO MATCH ACTORS AND MOVIES**************
INSERT INTO movies_actor(movie_id, actor_id)
    VALUE
    (1,1),(1,2),(1,3),(1,4),(1,5),(1,7),
    (3,6),
    (4,3),
    (5,5),
    (6,4),
    (2,7);