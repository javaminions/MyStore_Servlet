/***************************************
- Create Database if it does not exist
***************************************/

CREATE DATABASE mystore_servlet;
use mystore_servlet;

/***************************************
- Create Table if it does not exist
***************************************/

use mystore_servlet;
DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
	code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    inventory INT NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    img VARCHAR(255) NOT NULL
);

/***************************************
- Populate table with products
***************************************/

INSERT INTO Product(code, name, description, inventory, price, category, img) VALUES
("1", "Vans Sk8-Hi MTE Shoes", "The Vans All-Weather MTE Collection features footwear and apparel designed to withstand the elements whilst still looking cool.", 500, 45.99, "apparel", "https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/vans.png"),
("2", "Nesquick", "This is some nesquick. Mix it, mash it, snort it, whatever we don't care because it's always out of stock.", 0, 5.49, "groceries", "https://images-na.ssl-images-amazon.com/images/I/610AcjSnOJL._SL1000_.jpg"),
("3", "Wakeman Strike Fishing Rod", "This is a fishing rod that comes equipped with a spinning reel, ready to catch fish no matter where you are!", 500, 23.99, "outdoors","https://images-na.ssl-images-amazon.com/images/I/71GQBoTrYxL._AC_UL1500_.jpg"),
("4", "North Face Outdoor Backpack", "The North Face backpack is great for carrying your belongings and keeping its contents organized and protected.", 500, 59.99, "outdoors","https://images-na.ssl-images-amazon.com/images/I/81v3Gf2CoFL._AC_UL1500_.jpg"),
("5", "Coleman Camping Tent", "This is a large, high quality tent that can hold up to several people for overnight sleeping in the outdoors", 500, 144.99, "outdoors", "https://images-na.ssl-images-amazon.com/images/I/71K5ewxnQ4L._AC_SL1500_.jpg"),
("6", "Running Shoes", "Best running shoes in the business. You can run so fast, like really really fast", 500, 119.99, "apparel", 'https://javaminions.github.io/images/shoe.jpg'),
("7", "Visor", "This will totally block the sun out while you have a beer with your bros", 500, 19.99, "apparel", 'https://javaminions.github.io/images/visor.jpg'),
("8", "Soccer Ball", "Kick me up, kick me down, kick me all around. Surpass Messi and kick away!", 500, 79.99, "sports", 'https://javaminions.github.io/images/ball.jpg');