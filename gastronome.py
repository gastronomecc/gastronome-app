from firebase.firebase import FirebaseApplication

url="https://p2fsdgastro.firebaseio.com/"

def AddRecipe():
    title = input("Enter title of recipe:")
    calorie = input("Enter calorie of recipe:")
    dietary = input("Enter dietary type:")
    difficultylvl = input("Enter difficulty level of recipe:")
    ingredients = input("Enter ingredients needed in a list form:")
    instructions = input("Enter instruction in a list form:")
    prepTime = input("Enter preparation time needed:")
    readyTime = input("Enter time needed for recipe to be ready:")
    servsize = input("Enter serving size of recipe:")
    shortdescp = input ("Enter short description of recipe:")
    goaltype = input("Enter type of user recommended to:")

    

def RemoveRecipe():
    removerecipe = input("Enter name of Recipe you wish to remove")
    firebase = FirebaseApplication(url, None)
    firebase.delete("/Recipes","{0}".format())

def ResetDatabase():
    firebase = FirebaseApplication(url, None)

    #recipe 1, parmesan cloud egg
    firebase.put("/Recipes","Parmesan Cloud Eggs",{"calories":94,"dietary":"Vegetarian","difficulty":"Easy",
    "ingredients":{"0":"4 Large eggs, yolks and whites seperated","1":"Pinch of salt","2":"1/4 cup finely grated Parmesan cheese","3":"1 Scallion, finely chopped", "4":"Ground pepper to taste"},
    "instructions":{"0":"Preheat oven to 450°F. Line a large baking sheet with parchment paper. Lightly coat with cooking spray.",
     "1":"Separate egg whites from the yolks, placing each yolk in an individual small bowl. Beat all of the egg whites and salt in a mixing bowl with an electric mixer on high speed until stiff. Gently (about 3/4 cup each) of egg-cheese mixture on the prepared baking sheet. Make a well in the middle of each mound with the back of a spoon.",
     "2":"Bake the egg whites until starting to lightly brown, about 3 minutes. Remove from oven. If the well has filled in during baking, use the spoon to recreate it. Gently slip a yolk into each well. Bake until the yolks are cooked but still runny, 3 to 5 minutes more. Sprinkle with pepper. Serve immediately."},
    "prepTime":25, "readyTime":25, "servSize":4, "shortDesc":"These light and fluffy eggs are loaded with Parmesan and scallions for tons of flavor, plus there's a luscious runny yolk on top. And don't worry, this impressive brunch recipe is easy enough for anyone to master.",
    "title": "Parmesan Cloud Eggs", "type": "Get Fit", "fats":"6g","carbs":"1g","sugar":"0g","salt":"198mg","protein":"8g"})
    
    #recipe 2, avocado & kale omelet 
    firebase.put("/Recipes","Avocado & Kale Omelet",{"calories":339,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"2 Large eggs","1":"1 teaspoon low-fat milk","2":"Pinch of salt","3":"2 teaspoons extra-virgin olive oil, divided","4":"1 Cup of chopped kale","5":"1 Tablespoon lime juice","6":"1 tablespoon chopped fresh cilantro","7":"1 teaspoon unsalted sunflower seeds","8":"Pinch of crushed red pepper","9":"Pinch of salt","10":"1/4 Avocado, sliced"},"instructions":
    {"0":"Beat eggs with milk and salt in a small bowl. Heat 1 teaspoon oil in a small nonstick skillet over medium heat. Add the egg mixture and cook until the bottom is set and the center is still a bit runny, 1 to 2 minutes. Flip the omelet over and cook until set, about 30 seconds more. Transfer to a plate.",
    "1":"Toss kale with the remaining 1 teaspoon oil, lime juice, cilantro, sunflower seeds, crushed red pepper and a pinch of salt. Top the omelet with the kale salad and avocado."},
    "prepTime":10, "readyTime":10, "servSize":1, "shortDesc":"Move over, avocado toast. Top a high-protein omelet with avocado and fiber-rich kale and you'll keep hunger at bay for longer.",
    "title": "Avocado & Kale Omelet", "type": "Get Fit", "fats":"28g","carbs":"9g","sugar":"2g","salt":"446g","protein":"15g"})

    #recipe 3, Buttermilk Oatcakes with Raspberry Compote
    firebase.put("/Recipes","Buttermilk Oatcakes with Raspberry Compote",{"calories":303,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"2 cups well-shaken buttermilk or plain kefir","1":"1 large egg","2":"1½ cups old-fashioned rolled oats","3":"½ cup whole-wheat flour","4":"1 tablespoon sugar","5":"1 teaspoon baking soda","6":"½ teaspoon ground cinnamon","7":"¼ teaspoon salt","8":"2 cups raspberries, fresh or frozen (thawed)","9":"2 tablespoons maple syrup, or to taste","10":"1 teaspoon ground cinnamon"},"instructions":
    {"0":"To prepare oatcakes: Whisk buttermilk (or kefir) and egg in a medium bowl. Combine oats, flour, sugar, baking soda, ½ teaspoon cinnamon and salt in another medium bowl. Stir the dry mixture into the wet mixture and let stand for 15 minutes. The mixture will bubble slightly as it sits.",
     "1":"To prepare compote: Meanwhile, place raspberries, maple syrup and 1 teaspoon cinnamon in a small heavy saucepan. Bring to a simmer over medium heat and cook, stirring occasionally, until the berries are mostly broken down, 3 to 5 minutes. Remove from heat and cover to keep warm.",
     "2":"Coat a griddle or large nonstick skillet with cooking spray; heat over medium heat. Using ¼ cup of batter for each, cook 3 oatcakes at a time until bubbles dot the surface, 2 to 3 minutes. Flip and continue cooking until browned, 1 to 2 minutes more, reducing heat if necessary to prevent overbrowning.",
     "3":"Serve the oatcakes with the compote."},
    "prepTime":45, "readyTime":45, "servSize":4, "shortDesc":"These high-fiber oatcakes are made with 100% whole grains and no butter. A quick raspberry compote is a nice change from maple syrup.",
    "title": "Buttermilk Oatcakes with Raspberry Compote", "type": "Lose Weight", "fats":"5g","carbs":"55g","sugar":"19g","salt":"713mg","protein":"12g"})

    #recipe 4, Egg-in-a-Hole with Spinach & Bacon
    firebase.put("/Recipes","Egg-in-a-Hole with Spinach & Bacon",{"calories":302,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"3 slices center-cut bacon","1":"1 tablespoon extra-virgin olive oil, plus more if needed","2":"3 large cloves garlic, minced","3":"1 pound spinach (about 16 cups), tough stems removed","4":"1 teaspoon red-wine vinegar","5":"½ teaspoon ground pepper, divided","6":"¼ teaspoon salt","7":"4 large slices country-style whole-wheat bread ( ¾-1 inch thick)","9":"4 large eggs"},"instructions":
    {"0":"Preheat oven to 425°F. Coat a large baking sheet with cooking spray.",
     "1":"Cook bacon in a large cast-iron skillet over medium heat until crisp, 7 to 9 minutes. Drain on paper towels. Pour the bacon fat into a small heatproof bowl. If necessary, add oil to make 2 tablespoons.",
     "2":"Meanwhile, heat 1 tablespoon oil in a large saucepan over medium heat. Add garlic and cook, stirring, about 30 seconds. Add spinach by the handful and cook, stirring, until wilted, about 5 minutes. Transfer to a colander; press out excess liquid. Return the spinach to the pan and season with vinegar, ¼ teaspoon pepper and salt.",
     "3":"Cut a 3½-inch hole in the middle of each slice of bread. (Save the rounds for another use, if desired.) Heat 1 tablespoon of the reserved bacon fat in the skillet over medium-high heat. Cook 2 slices of bread, pressing with a spatula, until lightly browned, 1 to 3 minutes per side. Transfer to the prepared baking sheet. Repeat with the remaining fat and bread. Fill each hole with spinach. Make a deep well in the spinach and break an egg into each well.",
     "4":"Bake, rotating the baking sheet 180 degrees about halfway through, 10 to 14 minutes for soft-set yolks. Serve sprinkled with crumbled bacon and the remaining ¼ teaspoon pepper."},
    "prepTime":30, "readyTime":40, "servSize":4, "shortDesc":"When you make this cute breakfast-for-dinner recipe, also known as toad-in-a-hole or a one-eyed jack, you can vary it by using kale or even Swiss chard in place of the spinach.",
    "title": "Egg-in-a-Hole with Spinach & Bacon", "type": "Get Fit", "fats":"13g","carbs":"30g","sugar":"3g","salt":"646mg","protein":"19g"})

    #recipe 5, Avocado Toast with Egg, Cheddar & Kimchi
    firebase.put("/Recipes","Avocado Toast with Egg, Cheddar & Kimchi",{"calories":386,"dietary":"Vegetarian","difficulty":"Hard",
    "ingredients":{"0":"½ small avocado, mashed","1":"1 slice whole-grain bread, toasted","2":"Pinch of ground pepper","3":"2 tablespoons shredded Cheddar cheese","4":"½ teaspoon extra-virgin olive oil","5":"1 large egg","6":"2 tablespoons coarsely chopped kimchi"},"instructions":
    {"0":"Spread avocado on toast; season with pepper and sprinkle with cheese. Heat in a toaster oven (or broil) until the cheese is melted.",
     "1":"Meanwhile, heat oil in a small nonstick skillet over medium heat. Crack egg into the pan. Reduce heat to medium-low and cook 5 to 7 minutes for a soft-set yolk. Top the toast with the egg and kimchi."},
    "prepTime":20, "readyTime":20, "servSize":1, "shortDesc":"In this satisfying avocado-egg toast recipe, try full-flavored, high-fiber bread, like a hearty slice of German-style rye or seeded multigrain from your favorite bakery. To turn this into a portable breakfast, swap the toast for a whole-wheat English muffin or wrap.",
    "title": "Avocado Toast with Egg, Cheddar & Kimchi", "type": "Get Fit", "fats":"28g","carbs":"21g","sugar":"3g","salt":"359mg","protein":"16g"})

    #recipe 6, Ancho Chicken Breast with Black Beans, Bell Peppers & Scallions
    firebase.put("/Recipes","Ancho Chicken Breast with Black Beans, Bell Peppers & Scallions",{"calories":386,"dietary":"None","difficulty":"Hard",
    "ingredients":{"0":"1 tablespoon extra-virgin olive oil","1":"3 cloves garlic, minced","2":"1 teaspoon cumin seeds","3":"2 (15 ounce) cans low-sodium black beans, rinsed","4":"Juice of 1 lime","5":"¼ teaspoon kosher salt","6":"16 scallions, trimmed","7":"3 medium red bell peppers, cut into 1-inch strips","8":"1½ tablespoons extra-virgin olive oil plus 2 teaspoons, divided","9":"¾ teaspoon kosher salt, divided","10":"¼ teaspoon ground pepper","11":"2 (8 ounce) boneless, skinless chicken breasts, trimmed and halved crosswise","12":"1 teaspoon chilli powder","13":"½ teaspoon ground cinnamon","14":"½ teaspoon unsweetened cocoa powder","15":"1 teaspoon brown sugar"},"instructions":
    {"0":"To prepare beans: Heat 1 tablespoon oil in a medium saucepan over medium heat. Add garlic and cumin seeds; cook, stirring, until fragrant and starting to brown, 30 seconds to 1 minute. Stir in beans, lime juice and ¼ teaspoon salt and cook until hot, 2 to 4 minutes. Remove from heat and mash with a potato masher until mostly smooth. Refrigerate ½ cup of the mashed beans for another use (see Tips, below). Cover the remaining beans to keep warm.",
     "1":"To prepare chicken & vegetables: Position rack in upper third of oven; preheat broiler to high. Line a rimmed baking sheet with foil.",
     "2":"Toss scallions and bell peppers in a large bowl with 1½ tablespoons oil and ¼ teaspoon each salt and pepper. Transfer to the prepared baking sheet. Broil, stirring twice, until the vegetables are charred, 8 to 12 minutes.",
     "3":"Meanwhile, place chicken between 2 large pieces of plastic wrap. Pound with the smooth side of a meat mallet or a heavy saucepan to an even ½-inch thickness. Combine chile powder, cinnamon, cocoa, brown sugar and the remaining ½ teaspoon salt in a small bowl. Brush both sides of the chicken with the remaining 2 teaspoons oil and coat both sides with the spice mixture.",
     "4":"Coat a large grill pan or skillet with cooking spray and heat over medium-high heat. Reduce heat to medium and add half the chicken. Cook until an instant-read thermometer inserted in"},
    "prepTime":45, "readyTime":45, "servSize":4, "shortDesc":"In this healthy chicken recipe, the meat is rubbed with ancho chile powder, a spice made from dried poblano peppers. It adds mild heat and subtle smokiness to the rub on the chicken, but you can use regular chili powder here instead. This recipe makes an extra ½ cup of the black bean mash—try it wrapped into a burrito for lunch or as a taco filling",
    "title": "Ancho Chicken Breast with Black Beans, Bell Peppers & Scallions", "type": "Get Fit", "fats":"14g","carbs":"36g","sugar":"11g","salt":"464mg","protein":"32g"})

    #recipe 7, Spinach & Dill Pasta Salad
    firebase.put("/Recipes","Spinach & Dill Pasta Salad",{"calories":367,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"1 tablespoon white-wine vinegar","1":"1 tablespoon extra-virgin olive oil","2":"¼ teaspoon dried dill","3":"⅛ teaspoon garlic powder","4":"⅛ teaspoon salt","5":"⅛ teaspoon ground pepper","6":"¾ cup cooked whole-wheat fusilli or penne","7":"1 cup chopped spinach","8":"½ cup cherry tomatoes","9":"¼ cup shelled edamame (thawed if frozen)","10":"2 tablespoons shredded vegan cheese","11":"1 tablespoon finely chopped red onion"},"instructions":
    {"0":"Whisk vinegar, oil, dill, garlic powder, salt and pepper in a medium bowl. Add pasta, spinach, tomatoes, edamame, cheese and onion; stir to combine."},
    "prepTime":15, "readyTime":15, "servSize":1, "shortDesc":"Edamame gives this veggie-packed vegan pasta salad a bit of feel-full protein. Serve topped with extra freshly ground pepper, if desired.",
    "title": "Spinach & Dill Pasta Salad", "type": "Get Fit", "fats":"19g","carbs":"41g","sugar":"4g","salt":"417mg","protein":"12g"})

    #recipe 8, Chicken with Bell Pepper & Hominy Stir-Fry
    firebase.put("/Recipes","Chicken with Bell Pepper & Hominy Stir-Fry",{"calories":415,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"2 teaspoons canola oil","1":"1¼ pounds boneless, skinless chicken breast, trimmed and cut into 1-inch pieces","2":"3 teaspoons ground cumin, divided","3":"½ teaspoon kosher salt, divided","4":"½ cup finely chopped fresh cilantro","5":"2 medium red bell peppers, chopped","6":"2 cups sliced carrots","7":"1½ cups chopped red onion","8":"3 tablespoons water","9":"2 cups rinsed canned hominy","10":"2 cloves garlic, minced","11":"1 (4 ounce) can diced green chiles","12":"2 tablespoons lime juice","13":"1 firm ripe avocado, diced"},"instructions":
    {"0":"Heat oil in a large nonstick skillet over medium-high heat. Add chicken and sprinkle with 1 teaspoon cumin and ¼ teaspoon salt. Cook, stirring occasionally, until the chicken is just cooked through, 5 to 7 minutes. Transfer to a bowl and toss with cilantro. Cover to keep warm.",
     "1":"Add bell peppers, carrots, onion, water and the remaining ¼ teaspoon salt to the pan. Cook, stirring often, until the vegetables are crisp-tender, about 5 minutes. Stir in hominy, garlic and the remaining 2 teaspoons cumin; cook, stirring, for 1 minute. Stir in green chiles and lime juice and cook for 1 minute more.",
     "2":"Serve the chicken over the hominy mixture, topped with avocado."},
    "prepTime":15, "readyTime":15, "servSize":4, "shortDesc":"Hominy is made by soaking dried corn kernels in lime to remove the tough hull and germ. The result looks like puffed-up corn, perhaps most notably enjoyed in the Mexican soup posole. In this healthy chicken stir-fry recipe, the hominy is added along with the vegetables to make a hearty dinner.",
    "title": "Chicken with Bell Pepper & Hominy Stir-Fry", "type": "Gain Muscles", "fats":"15g","carbs":"34g","sugar":"10g","salt":"485mg","protein":"37g"})
    
    #recipe 9, Creamy Garlic Pasta with Shrimp & Vegetables
    firebase.put("/Recipes","Creamy Garlic Pasta with Shrimp & Vegetables",{"calories":361,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"6 ounces whole-wheat spaghetti","1":"12 ounces peeled and deveined raw shrimp (see Note), cut into 1-inch pieces","2":"1 bunch asparagus, trimmed and thinly sliced","3":"1 large red bell pepper, thinly sliced","4":"1 cup fresh or frozen peas","5":"3 cloves garlic, chopped","6":"1¼ teaspoons kosher salt","7":"1½ cups nonfat or low-fat plain yogurt","8":"¼ cup chopped flat-leaf parsley","9":"3 tablespoons lemon juice","10":"1 tablespoon extra-virgin olive oil","11":"½ teaspoon freshly ground pepper"},"instructions":
    {"0":"Bring a large pot of water to a boil. Add spaghetti and cook 2 minutes less than package directions. Add shrimp, asparagus, bell pepper and peas and cook until the pasta is tender and the shrimp are cooked, 2 to 4 minutes more. Drain well.",
     "1":"Mash garlic and salt in a large bowl until a paste forms. Whisk in yogurt, parsley, lemon juice, oil and pepper. Add the pasta mixture and toss to coat."},
    "prepTime":30, "readyTime":30, "servSize":4, "shortDesc":"Toss a garlicky, Middle Eastern-inspired yogurt sauce with pasta, shrimp, asparagus, peas and red bell pepper for a fresh, satisfying summer meal. Serve with: Slices of cucumber and tomato tossed with lemon juice and olive oil.",
    "title": "Creamy Garlic Pasta with Shrimp & Vegetables", "type": "Get Fit", "fats":"6g","carbs":"53g","sugar":"14g","salt":"949mg","protein":"28g"})

    #recipe 10, Chicken & Spinach Soup with Fresh Pesto
    firebase.put("/Recipes","Chicken & Spinach Soup with Fresh Pesto",{"calories":226,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"2 teaspoons plus 1 tablespoon extra-virgin olive oil, divided","1":"½ cup carrot or diced red bell pepper","2":"1 large boneless, skinless chicken breast (about 8 ounces), cut into quarters","3":"1 large clove garlic, minced","4":"5 cups reduced-sodium chicken broth","5":"1½ teaspoons dried marjoram","6":"6 ounces baby spinach, coarsely chopped","7":"1 15-ounce can cannellini beans or great northern beans, rinsed","8":"¼ cup grated Parmesan cheese","9":"⅓ cup lightly packed fresh basil leaves","10":"Freshly ground pepper to taste","11":"¾ cup plain or herbed multigrain croutons for garnish (optional)"},"instructions":
    {"0":"Heat 2 teaspoons oil in a large saucepan or Dutch oven over medium-high heat. Add carrot (or bell pepper) and chicken; cook, turning the chicken and stirring frequently, until the chicken begins to brown, 3 to 4 minutes. Add garlic and cook, stirring, for 1 minute more. Stir in broth and marjoram; bring to a boil over high heat. Reduce the heat and simmer, stirring occasionally, until the chicken is cooked through, about 5 minutes.",
     "1":"With a slotted spoon, transfer the chicken pieces to a clean cutting board to cool. Add spinach and beans to the pot and bring to a gentle boil. Cook for 5 minutes to blend the flavors.",
     "2":"Combine the remaining 1 tablespoon oil, Parmesan and basil in a food processor (a mini processor works well). Process until a coarse paste forms, adding a little water and scraping down the sides as necessary.",
     "3":"Cut the chicken into bite-size pieces. Stir the chicken and pesto into the pot. Season with pepper. Heat until hot. Garnish with croutons, if desired."},
    "prepTime":30, "readyTime":30, "servSize":5, "shortDesc":"This fragrant, Italian-flavored soup takes advantage of quick-cooking ingredients—boneless, skinless chicken breast, bagged baby spinach and canned beans. It features a simple homemade basil pesto swirled in at the end to add a fresh herb flavor.",
    "title": "Chicken & Spinach Soup with Fresh Pesto", "type": "Lose Weight", "fats":"9g","carbs":"18g","sugar":"2g","salt":"211mg","protein":"19g"})

    #recipe 11, Shrimp Poke
    firebase.put("/Recipes","Shrimp Poke",{"calories":460,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"¾ cup thinly sliced scallion greens","1":"¼ cup reduced-sodium tamari","2":"1½ tablespoons mirin","3":"1½ tablespoons toasted (dark) sesame oil","4":"1 tablespoon white sesame seeds","5":"2 teaspoons grated fresh ginger","6":"½ teaspoon crushed red pepper (optional)","7":"12 ounces cooked shrimp, cut into ½-inch pieces","8":"2 cups cooked brown rice","9":"2 tablespoons rice vinegar","10":"2 cups sliced cherry tomatoes","11":"2 cups diced avocado","12":"¼ cup chopped cilantro","13":"¼ cup toasted black sesame seeds"},"instructions":
    {"0":"Whisk scallion greens, tamari, mirin, oil, white sesame seeds, ginger and crushed red pepper, if using, in a medium bowl. Set aside 2 tablespoons of the sauce in a small bowl. Add shrimp to the sauce in the medium bowl and gently toss to coat.",
     "1":"Combine rice and vinegar in a large bowl. Divide among 4 bowls and top each with ¾ cup shrimp, ½ cup each tomatoes and avocado, and 1 tablespoon each cilantro and black sesame seeds. Drizzle with the reserved sauce and serve."},
    "prepTime":30, "readyTime":30, "servSize":4, "shortDesc":"Not a fan of raw fish? No problem—this poke (pronounced poke-ay) recipe substitutes cooked peeled shrimp instead. This fast, veggie-loaded dish includes seasoned brown rice for a hearty boost of fiber.",
    "title": "Shrimp Poke", "type": "Get Fit", "fats":"22g","carbs":"40g","sugar":"4g","salt":"861mg","protein":"29g"})

    #recipe 12, Creamy Fettuccine with Brussels Sprouts & Mushrooms
    firebase.put("/Recipes","Creamy Fettuccine with Brussels Sprouts & Mushrooms",{"calories":384,"dietary":"None","difficulty":"Hard",
    "ingredients":{"0":"12 ounces whole-wheat fettuccine","1":"1 tablespoon extra-virgin olive oil","2":"4 cups sliced mixed mushrooms, such as cremini, oyster and/or shiitake","3":"4 cups thinly sliced Brussels sprouts","4":"1 tablespoon minced garlic","5":"½ cup dry sherry (see Note), or 2 tablespoons sherry vinegar","6":"2 cups low-fat milk","7":"2 tablespoons all-purpose flour","8":"½ teaspoon salt","9":"½ teaspoon freshly ground pepper","10":"1 cup finely shredded Asiago cheese, plus more for garnish"},"instructions":
    {"0":"Cook pasta in a large pot of boiling water until tender, 8 to 10 minutes. Drain, return to the pot and set aside.",
     "1":"Meanwhile, heat oil in a large skillet over medium heat. Add mushrooms and Brussels sprouts and cook, stirring often, until the mushrooms release their liquid, 8 to 10 minutes. Add garlic and cook, stirring, until fragrant, about 1 minute. Add sherry (or vinegar), scraping up any brown bits; bring to a boil and cook, stirring, until almost evaporated, 10 seconds (if using vinegar) or about 1 minute (if using sherry).",
     "2":"Whisk milk and flour in a bowl; add to the skillet with salt and pepper. Cook, stirring, until the sauce bubbles and thickens, about 2 minutes. Stir in Asiago until melted. Add the sauce to the pasta; gently toss. Serve with more cheese, if desired."},
    "prepTime":30, "readyTime":30, "servSize":6, "shortDesc":"Sliced Brussels sprouts and mushrooms cook quickly and cling to the pasta in our fall version of pasta primavera. Look for presliced mushrooms to cut prep time. Serve with a tossed salad.",
    "title": "Creamy Fettuccine with Brussels Sprouts & Mushrooms", "type": "Get Fit", "fats":"10g","carbs":"56g","sugar":"8g","salt":"431mg","protein":"18g"})

    #recipe 13 Roasted Salmon & Butternut Squash Salad
    firebase.put("/Recipes","Roasted Salmon & Butternut Squash Salad",{"calories":422,"dietary":"Omega-3","difficulty":"Easy",
    "ingredients":{"0":"1 16-ounce package diced peeled butternut squash","1":"5 tablespoons extra-virgin olive oil, divided","2":"1 teaspoon salt, divided","3":"¾ teaspoon ground pepper, divided","4":"1¼ pounds salmon fillet (see Tips), skinned and cut into 4 portion","5":"5 tablespoons cider vinegar","6":"1 tablespoon maple syrup","7":"1 teaspoon whole-grain mustard","8":"1 5-ounce package arugula","9":"3 cups chopped red cabbage"},"instructions":
    {"0":"Preheat oven to 425°F.",
     "1":"Toss squash with 1 tablespoon oil and ¼ teaspoon each salt and pepper. Spread on a large rimmed baking sheet. Roast, stirring once, for 15 minutes.",
     "2":"Push the squash to one side of the pan and line the empty side with foil. Place salmon on the foil and sprinkle with ¼ teaspoon each salt and pepper. Continue roasting until the squash is tender and the salmon is cooked through, 5 to 10 minutes more.",
     "3":"Meanwhile, whisk the remaining 4 tablespoons oil, ½ teaspoon salt and ¼ teaspoon pepper with vinegar, maple syrup and mustard in a large bowl. Set aside 2 tablespoons of the dressing. Add arugula, cabbage and the squash to the large bowl and gently toss. Serve the salad topped with the salmon and drizzled with the reserved dressing.",
     "4":"Precut butternut squash is usually sold in a 16-ounce package diced squash (3 cups of ½-inch pieces) or a in a 20-ounce package of large cubes (5 cups of 1- to 2-inch pieces). If you can only find the larger cubes for this recipe, cut them into ½-inch dice before cooking and measure out about 3 cups. Or, you can prep your own diced squash from a whole, peeled and seeded butternut squash."},
    "prepTime":30, "readyTime":35, "servSize":4, "shortDesc":"The natural sweetness of the squash is amplified by a maple syrup-spiked dressing in this hearty salmon salad. Serve with crusty garlic bread and a glass of Beaujolais wine.",
    "title": "Roasted Salmon & Butternut Squash Salad", "type": "Get Fit", "fats":"23g","carbs":"22g","sugar":"8g","salt":"706mg","protein":"31g"})

    #recipe 14 Pistachio-Crusted Chicken with Warm Barley Salad
    firebase.put("/Recipes","Pistachio-Crusted Chicken with Warm Barley Salad",{"calories":565,"dietary":"None","difficulty":"Hard",
    "ingredients":{"0":"Olive oil or canola oil cooking spray","1":"2 cups water plus 1 tablespoon, divided","2":"1 cup quick barley","3":"1 cup salted shelled pistachios, divided","4":"½ cup whole-wheat panko breadcrumbs","5":"1 teaspoon orange zest","6":"½ teaspoon garlic powder","7":"1 large egg white","8":"2 (8 ounce) boneless, skinless chicken breasts, trimmed and cut in half crosswise","9":"½ teaspoon salt, divided","10":"2 tablespoons extra-virgin olive oil","11":"1 cup cherry tomatoes, halved","12":"1 tablespoon white-wine vinegar","13":"1 cup chopped fresh parsley"},"instructions":
    {"0":"Preheat oven to 450°F. Coat a wire rack with cooking spray and place on a foil-lined baking sheet",
     "1":"Bring 2 cups water and barley to a boil in a small saucepan. Reduce heat, cover and simmer until tender, 10 to 12 minutes. Set aside.",
     "2":"Meanwhile, pulse ¾ cup pistachios, breadcrumbs, orange zest and garlic powder in a food processor until the pistachios are coarsely chopped. Transfer to a shallow dish. Whisk egg white and the remaining 1 tablespoon water in another shallow dish.",
     "3":"Place chicken between 2 pieces of plastic wrap. Pound with the smooth side of a meat mallet or heavy saucepan to an even ½-inch thickness. Sprinkle the chicken with ¼ teaspoon salt, coat with the egg mixture and dredge in the pistachio mixture, patting to adhere. Place on the prepared rack. Coat both sides of the chicken with cooking spray.",
     "4":"Bake the chicken until an instant-read thermometer inserted in the thickest part registers 165°F, about 15 minutes.",
     "5":"Heat oil in a large skillet over medium heat. Add tomatoes and vinegar. Cook until the tomatoes just start to collapse, about 1 minute. Remove from heat.",
     "6":"Drain the barley, if necessary, and stir into the tomatoes along with the remaining ¼ cup pistachios, ¼ teaspoon salt and parsley. Serve with the chicken."},
    "prepTime":30, "readyTime":30, "servSize":4, "shortDesc":"Barley and pistachios give this healthy chicken recipe a double dose of nutty flavor. For an easy change-up, swap in your favorite whole grain, such as brown rice, farro or quinoa.",
    "title": "Pistachio-Crusted Chicken with Warm Barley Salad", "type": "Get Muscles", "fats":"27g","carbs":"47g","sugar":"4g","salt":"514mg","protein":"36g"})

    #recipe 15 Vegetarian Shepherd's Pies
    firebase.put("/Recipes","Vegetarian Shepherd's Pies",{"calories":322,"dietary":"Vegetarian","difficulty":"Medium",
    "ingredients":{"0":"1 pound Yukon Gold or white potatoes, peeled and cut into 1-inch chunks","1":"½ cup buttermilk","2":"1 tablespoon butter","3":"¾ teaspoon salt, divided","4":"½ teaspoon freshly ground pepper, divided","5":"1 tablespoon extra-virgin olive oil","6":"1 large onion, finely diced","7":"½ cup finely diced carrot","8":"1 tablespoon water","9":"¾ cup frozen corn kernels, thawed","10":"1 teaspoon chopped fresh thyme or ½ teaspoon dried","11":"3 tablespoons all-purpose flour","12":"1 14-ounce can vegetable broth","13":"1½ cups cooked or canned (rinsed) lentils"},"instructions":
    {"0":"Place potatoes in a large saucepan and cover with 2 inches of water. Bring to a simmer over medium-high heat. Reduce heat to medium, partially cover and cook until tender, 10 to 15 minutes. Drain and return the potatoes to the pot. Add buttermilk, butter and ¼ teaspoon each salt and pepper. Mash with a potato masher until mostly smooth.",
     "1":"While the potatoes are cooking, position rack in upper third of oven; preheat broiler. Coat four 10- to 12-ounce broiler-safe ramekins (or an 8-inch-square broiler-safe baking dish) with cooking spray. Place ramekins on a broiler-safe baking sheet.",
     "2":"Heat oil in a large skillet over medium-high heat. Add onion, carrot and water. Cover and cook, stirring occasionally, until softened, 3 to 5 minutes. Stir in corn, thyme and the remaining ½ teaspoon salt and ¼ teaspoon pepper; cook, stirring occasionally, for 2 minutes. Sprinkle with flour and stir to coat. Stir in broth. Bring to a simmer; cook, stirring, for 1 minute. Stir in lentils and cook, stirring constantly, for 2 minutes.",
     "3":"Divide the hot lentil mixture among the prepared ramekins (or spread in the baking dish). Top with the mashed potatoes. Broil, rotating halfway through, until the potato is lightly browned in spots, 6 to 10 minutes."},
    "prepTime":45, "readyTime":45, "servSize":4, "shortDesc":"These mini vegetarian shepherd's pies feature lentils, carrot and corn, crowned with a velvety mashed potato topping.",
    "title": "Vegetarian Shepherd's Pies", "type": "Get Fit", "fats":"7g","carbs":"54g","sugar":"8g","salt":"783mg","protein":"12g"})

    #recipe 16 Summer Stewed Fish
    firebase.put("/Recipes","Summer Stewed Fish",{"calories":325,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"4 Slides stale bread, diced","1":"2 tablespoon Olive oil","2":"1 Onion, finely chopped","3":"2 Garlic cloves, crushed","4":"1 tablespoon Dried chilli flakes","5":"400g Can Chopped Tomatoes","6":"4 Frozen white Fish Fillets, such as cod or pollock","7":"400g Can Butter Beans, drained","8":"Small pack parsley, roughly chopped","9":"1 Lemon, cut into wedges"},"instructions":
    {"0":"Heat oven to 200C/180C fan/gas 6. Put the bread on a large baking sheet, drizzle over 1 tbsp oil and bake for 10 mins until golden. Set aside.",
     "1":"Meanwhile, heat the rest of the oil in a large flameproof casserole dish over a medium heat. Add the onion and cook until softened for about 10 mins, then add the garlic and chilli flakes and stir for 1 min. Tip in the tomatoes and fish fillets. Cover and simmer for 10 mins until the fish is nearly cooked, then uncover.",
     "2":"Tip in the butter beans, season well, then cook until everything is hot. Serve scattered with the croutons, parsley and lemon."},
    "prepTime":10, "readyTime":25, "servSize":4, "shortDesc":"This storecupboard fish stew is bulked out with bread and is full of fresh, summer flavours",
    "title": "Summer fish stew", "type": "Lose Weight", "fats":"7g","carbs":"26g","sugar":"8g","salt":"700mg","protein":"34g"})

    #recipe 17 Asian pulled chicken salad
    firebase.put("/Recipes","Asian pulled chicken salad",{"calories":352,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"1 small roasted chicken, about 1kg","1":"½ red cabbage, cored and finely sliced","2":"3 carrots, coarsley grated or finely shredded","3":"5 spring onions, finely sliced on the diagonal","4":"2 red chillies, halved and thinly sliced","5":"small bunch coriander, roughly chopped, including stalks","6":"2 heaped tbsp roasted salted peanuts, roughly crushed","7":"3½ tbsp hoisin sauce","8":"1½ tbsp toasted sesame oil"},"instructions":
    {"0":"Combine the dressing ingredients in a small bowl and set aside.",
     "1":"Remove all the meat from the chicken, shred into large chunks and pop in a large bowl. Add the cabbage, carrots, spring onions, chillies and half the coriander. Toss together with the dressing and pile onto a serving plate, then scatter over the remaining coriander and peanuts."},
    "prepTime":45, "readyTime":45, "servSize":1, "shortDesc":"Pull apart a ready-roasted chicken to whip up this healthy, vibrant, low-calorie dish in just 20 minutes",
    "title": "Asian pulled chicken salad", "type": "Lose Weight", "fats":"19g","carbs":"14g","sugar":"11g","salt":"800mg","protein":"29g"})

    #recipe 18 Prawn & tomato stew with gremolata topping
    firebase.put("/Recipes","Prawn & tomato stew with gremolata topping",{"calories":308,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"500g new potato","1":"2 tbsp olive oil","2":"1 large onion, sliced","3":"4 celery sticks, cut into pieces","4":"2 garlic cloves, chopped","5":"2 anchovy fillets, chopped","6":"pinch chilli flakes","7":"400g can chopped tomato","8":"250ml white wine","9":"200ml vegetable stock","10":"400g raw king prawn, peeled","11":"zest and juice 1 lemon","12":"1 tsp salted baby caper, rinsed","13":"large handful parsley, chopped","14":"toasted bread, to serve"},"instructions":
    {"0":"Put the potatoes in a saucepan of cold salted water and bring to the boil. Reduce the heat to medium and simmer for 15-20 mins or until cooked but still firm. Drain and, when cool enough to handle, thickly slice.",
     "1":"Meanwhile, heat the oil in a large saucepan over a low-medium heat. Add the onion, celery, garlic, anchovy and chilli, season and cook for 8 mins or until softened. Increase the heat to medium-high, add the tomatoes, wine and stock, and cook for 15 mins. Add the prawns, lemon juice, capers and potatoes. Cook for 5 mins more, or until the prawns turn pink and are just cooked. Mix together the parsley and lemon zest, then scatter over the stew, then serve with toasted bread, for dunking."},
    "prepTime":10, "readyTime":35, "servSize":4, "shortDesc":"A fish casserole with healthy prawns, topped with an Italian garnish of parsley and lemon zest - it's low in fat and calories too",
    "title": "Prawn & tomato stew with gremolata topping", "type": "Lose Weight", "fats":"7g","carbs":"29g","sugar":"10g","salt":"1g","protein":"22g"})

    #recipe 19 Greek-style roast fish
    firebase.put("/Recipes","Greek-style roast fish",{"calories":388,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"5 small potatoes(about 400g), scrubbed and cut into wedges","1":"1 onion, halved and sliced","2":"2 garlic cloves, roughly chopped","3":"½ tsp dried oregano or ½ tbsp chopped fresh oregano","4":"2 tbsp olive oil","5":"½ lemon, cut into wedges","6":"2 large tomatoes, cut into wedges","7":"2 fresh skinless pollock fillets (about 200g)","8":"small handful parsley, roughly chopped"},"instructions":
    {"0":"Heat oven to 200C/180C fan/gas 6. Tip the potatoes, onion, garlic, oregano and olive oil into a roasting tin, season, then mix together with your hands to coat everything in the oil. Roast for 15 mins, turn everything over and bake for 15 mins more.",
     "1":"Add the lemon and tomatoes, and roast for 10 mins, then top with the fish fillets and cook for 10 mins more. Serve with parsley scattered over."},
    "prepTime":10, "readyTime":50, "servSize":2, "shortDesc":"Oven-bake white fish fillets with potatoes, tomatoes and herbs for a healthy and gluten-free weeknight dinner",
    "title": "Greek-style roast fish", "type": "Lose Weight", "fats":"13g","carbs":"42g","sugar":"11g","salt":"400mg","protein":"23g"})

    #recipe 20 Prawn, fennel & rocket risotto
    firebase.put("/Recipes","Prawn, fennel & rocket risotto",{"calories":391,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"1.2l vegetable stock","1":"1 tbsp olive oil","2":"1 onion, finely chopped","3":"1 large garlic clove, finely chopped","4":"1 small fennel bulb, cored and finely chopped","5":"300g risotto rice","6":"300g peeled raw king prawns","7":"1 lemon, ½ zested and 1 tbsp juice","8":"70g bag rocket"},"instructions":
    {"0":"Put the stock in a large saucepan, bring to the boil, then lower to a simmer. Meanwhile, heat the oil in a large saucepan. Add the onion, garlic and fennel, and cook on a low heat for 10 mins until the vegetables have softened but not coloured. Add the rice and stir for 2 mins until the grains are hot and making crackling sounds. Increase the heat to medium and start adding the stock, a ladleful at a time, stirring constantly and making sure the stock has absorbed into the rice before adding the next ladleful.",
     "1":"When the rice is almost cooked, add the prawns, lemon zest and some seasoning. Continue adding stock and cooking for another 3-4 mins until the prawns are pink and the rice is cooked. Remove from the heat and stir through the rocket and lemon juice. Check the seasoning, leave the risotto to sit in the pan for 2 mins, then serve."},
    "prepTime":15, "readyTime":35, "servSize":4, "shortDesc":"This prawn and fennel risotto gets a little extra kick from lemon zest and and rocket - perfect for a dinner party",
    "title": "Prawn, fennel & rocket risotto", "type": "Get Fit", "fats":"5g","carbs":"64g","sugar":"5g","salt":"1200mg","protein":"21g"})

    #recipe 21 Paillard of chicken with lemon & herbs
    firebase.put("/Recipes","Paillard of chicken with lemon & herbs",{"calories":240,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"6 skinless chicken breasts","1":"2 tbsp olive oil","2":"1⁄2 tbsp balsamic vinegar","3":"140g bag rocket","4":"25g parmesan","5":"lemon wedges","6":"2 garlic cloves","7":"3 rosemary sprigs, leaves finely chopped","8":"6 sage leaves, finely shredded","9":"zest 1 lemon and juice of ½","10":"3 tbsp olive oil"},"instructions":
    {"0":"Place each chicken breast between 2 sheets of cling film or baking parchment. Use a meat mallet or rolling pin to bash each piece of chicken – flatten out to an even layer about 0.5cm thick. Transfer to a dish.",
     "1":"To make the marinade, crush the garlic with a good pinch of salt using a pestle and mortar. Add the rosemary and sage, and give everything a good pounding. Stir through the lemon zest and juice, olive oil and some ground black pepper. Pour the marinade over the chicken, ensuring that it’s well coated. Cover and chill for at least 2 hrs.",
     "2":"Heat the barbecue. Once the flames have died down, spread the coals out to an even layer. Cook the chicken for 1-2 mins each side. Transfer to a board and leave to rest for a few mins.",
     "3":"Meanwhile, pour the oil and balsamic vinegar into a large bowl. Add the rocket and some seasoning. Toss together, then shave over the Parmesan. Serve the salad with the chicken, with lemon wedges to squeeze over."},
    "prepTime":15, "readyTime":5, "servSize":6, "shortDesc":"Pounding meat until thin and flat is a great technique for barbecued chicken breast, as it ensures it won’t dry out. Try this version with lemon and herbs.",
    "title": "Paillard of chicken with lemon & herbs", "type": "Get Fit", "fats":"12g","carbs":"1g","sugar":"1g","salt":"300mg","protein":"32g"})

    #recipe 22 Superhealthy salmon burger
    firebase.put("/Recipes","Superhealthy salmon burgers",{"calories":292,"dietary":"None","difficulty":"Easy",
    "ingredients":{"0":"4 boneless, skinless salmon fillets, about 550g/1lb 4oz in total, cut into chunks","1":"2 tbsp Thai red curry paste","2":"thumb-size piece fresh root ginger, grated","3":"1 tsp soy sauce","4":"1 bunch coriander, half chopped, half leaves picked","5":"1 tsp vegetable oil","6":"lemon wedges, to serve","7":"2 carrots","8":"half large or 1 small cucumbe","9":"2 tbsp white wine vinegar","10":"1 tsp golden caster sugar"},"instructions":
    {"0":"Tip the salmon into a food processor with the paste, ginger, soy and chopped coriander. Pulse until roughly minced. Tip out the mix and shape into 4 burgers. Heat the oil in a non-stick frying pan, then fry the burgers for 4-5 mins on each side, turning until crisp and cooked through.",
     "1":"Meanwhile, use a swivel peeler to peel strips of carrot and cucumber into a bowl. Toss with the vinegar and sugar until the sugar has dissolved, then toss through the coriander leaves. Divide the salad between 4 plates. Serve with the burgers and rice."},
    "prepTime":20, "readyTime":10, "servSize":4, "shortDesc":"If you're after something a bit lighter than potato-packed fishcakes, try these simple oriental-style burgers",
    "title": "Superhealthy salmon burgers", "type": "Gain Muscle", "fats":"","carbs":"","sugar":"","salt":"","protein":""})

    #recipe 23 Asian tofu with stir-fried noodles, pak choi & sugar snap peas
    firebase.put("/Recipes","Asian tofu with stir-fried noodles, pak choi & sugar snap pea",{"calories":328,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"195g extra-firm tofu","1":"2 tsp tamari or soy sauce","2":"2cm piece ginger, peeled and finely chopped or grated","3":"1 garlic clove, finely chopped","4":"2 tbsp lemon or lime juice","5":"1 tsp sesame oil","6":"85g vermicelli rice noodle","7":"2 tsp rapeseed oil","8":"1 tsp sesame oil","9":"1 spring onion, trimmed and thinly sliced","10":"1 garlic clove, finely chopped","11":"½ red chilli, deseeded and finely chopped","12":"2cm piece ginger, peeled and finely chopped","13":"100g sugar snap pea","14":"100g pak choi (or spinach)","15":"1 large red pepper, sliced","16":"1 tsp tamari or soy sauce","17":"juice ½ lime","18":"1 tbsp finely chopped coriander"},"instructions":
    {"0":"Make the marinade by mixing together all the ingredients. Drain the tofu by placing on several sheets of kitchen paper on a plate, with several more on top, and a heavy weight (such as a pan) on top of that. Leave for at least 15 mins. Cut the tofu into cubes and put in  a small bowl with the marinade. Cover and leave for 30 mins-1 hr.",
     "1":"Meanwhile, cook the noodles following pack instructions, then drain and sit them in a bowl of cold water.",
     "2":"Heat a non-stick frying pan. Add the tofu pieces and fry until hot and crispy. Just before you remove the tofu from the pan, add any remaining marinade and let it sizzle for 10 secs. Place the tofu on a plate and cover with foil to keep warm.",
     "3":"In a frying pan or wok, heat the rapeseed and sesame oils over a high heat. Add the spring onion, garlic, chilli and ginger, and stir constantly for about 1 min. Add the sugar snap peas, pak choi and pepper, and stir for another 1-2 mins, then add the cooked noodles. Toss well, then add the soy sauce and lime juice, and mix until well combined and the pan is sizzling.",
     "4":"Remove from the heat and divide between 2 bowls. Top each with tofu cubes and drizzle over any juices. Sprinkle with coriander and serve. "},
    "prepTime":10, "readyTime":15, "servSize":2, "shortDesc":"A vegetarian stir-fry packed with spice and flavour. Marinate tofu in ginger, garlic and sesame and serve with a vermicelli noodle mix",
    "title": "Asian tofu with stir-fried noodles, pak choi & sugar snap pea", "type": "Gain Muscles", "fats":"9g","carbs":"45g","sugar":"9g","salt":"1100mg","protein":"15g"})

    #recipe 24 One-Pot Chili Pasta
    firebase.put("/Recipes","One-Pot Chili Pasta",{"calories":646,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"1 Tbsp olive oil","1":"1 medium onion","2":"2 cloves garlic","3":"1/2 lb ground beef","4":"2 Tbsp flour","5":"2 Tbsp chili powder","6":"15 oz can tomato sauce","7":"15 oz can diced tomatoes","8":"15 oz can black beans","9":"15 oz can kidney beans","10":"1 cup frozen corn kernels","11":"2 cups uncooked elbow macaroni","12":"2 cups beef broth","13":"1 cup shredded cheese"},"instructions":
    {"0":"Dice the onion and mince the garlic. Cook both in a large pot with olive oil over medium heat for 1-2 minutes, or until soft and transparent. Add the ground beef and continue to stir and cook until it is fully browned. If using a high fat ground beef, drain off the excessive after it is browned.",
     "1":"Add the flour and chili powder to the pot and stir to coat the meat. Continue to stir and cook the coated meat for 1-2 minutes more. The flour and chili powder may coat the bottom of the pot, but that's okay. Just be careful to not let it burn.",
     "2":"Drain and rinse the black and kidney beans. Add the beans, tomato sauce, diced tomato, and corn kernels to the pot. Stir well and dissolve the flour/chili powder mixture from the bottom of the pot.",
     "3":"Add the dry macaroni and two cups of beef broth to the pot and stir to combine. Place a lid on top, turn the heat up to high, and let the pot come to a boil. Once it reaches a boil, give it a quick stir to loosen any pasta stuck to the bottom of the pot, replace the lid, and turn the heat down to medium-low. Let the pot simmer on medium-low for about 15 minutes, or until the pasta is soft and has absorbed most of the liquid. Stir the pot one or two times during the 15 minutes to loosen any pasta stuck to the bottom.",
     "4":"Once the pasta is fully cooked, turn the heat off and add the cheese. Stir the cheese into the pasta until it has melted in and become slightly creamy. Serve hot."},
    "prepTime":10, "readyTime":30, "servSize":2, "shortDesc":"A vegetarian stir-fry packed with spice and flavour. Marinate tofu in ginger, garlic and sesame and serve with a vermicelli noodle mix",
    "title": "One-Pot Chili Pasta", "type": "Gain Muscles", "fats":"15g","carbs":"85g","sugar":"0g","salt":"0g","protein":"44g"})


    #recipe 25 Lamb of Gains
    firebase.put("/Recipes","Lamb of Gains",{"calories":888,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"1 rack of lamb (about 1 1/2 pounds, or 8 ribs), cut into chops and trimmed of fat","1":"Salt and Pepper, to taste","2":"1lb carrots","3":"3 Tbsp Dijon mustard","4":"2 Tbsp extra-virgin olive oil","5":"2 Tbsp finely chopped fresh cilantro","6":"2 Tbsp chopped scallions","7":"2 Tbsp red wine vinegar","8":"1 Tsp loosely packed orange zest"},"instructions":
    {"0":"Heat a large skillet over medium-high heat. Season lamb with salt and pepper and add to skillet. Sear one side, then cook for 2 minutes on each side.",
     "1":"While the lamb cooks, add carrots to a running food processor, using chopper to push carrots through. Or grate the carrots on the large holes of a box grater.",
     "2":"In a large mixing bowl, whisk together Dijon mustard, olive oil, cilantro, scallions, vinegar, and orange zest. Add carrots and, with clean hands, toss with the dressing until carrots are well coated. Season with pepper. Let carrots marinate for 10 minutes. Serve with the lamb."},
    "prepTime":10, "readyTime":30, "servSize":2, "shortDesc":"A vegetarian stir-fry packed with spice and flavour. Marinate tofu in ginger, garlic and sesame and serve with a vermicelli noodle mix",
    "title": "Lamb of Gains", "type": "Gain Muscles", "fats":"21g","carbs":"50g","sugar":"0g","salt":"0g","protein":"86g"})

    #recipe 26 Vanilla Almond Butter Protein Granola
    firebase.put("/Recipes","Vanilla Almond Butter Protein Granola",{"calories":161,"dietary":"None","difficulty":"Medium",
    "ingredients":{"0":"1/4 cup almond butter","1":"1/4 cup honey","2":"1 tsp. vanilla extract","3":"2 cup rolled oats","4":"1 serving vanilla protein powder (optional)","5":"2 Tbsp. ground flax","6":"1 tsp. cinnamon","7":"1/4 tsp. salt","8":"1/3 cup chocolate chips"},"instructions":
    {"0":"Preheat oven to 325F and spray a baking sheet with cooking spray or line it with parchment paper or a non-stick baking mat. Set aside.",
     "1":"In a small saucepan over medium-low heat, add almond butter and honey, stirring until the almond butter is melted and fully combined with the honey. Stir in vanilla extract.",
     "2":"Remove from heat and add oats, protein powder (if using), flax, cinnamon, and salt. Mix well and use a spatula to ensure that all of the oats are well coated.",
     "3":"Spread the granola mixture over a baking sheet, leaving as many clusters as you want, and bake for 8 minutes. Remove from oven, stir, and bake for another 8 minutes, or until lightly golden.",
     "4":"Let cool completely before adding chocolate chips and transferring to a storage container. The granola will still be slightly soft when it comes out of the oven, but it will harden up as it sits at room temperature and cools."},
    "prepTime":10, "readyTime":16, "servSize":2, "shortDesc":"A vegetarian stir-fry packed with spice and flavour. Marinate tofu in ginger, garlic and sesame and serve with a vermicelli noodle mix",
    "title": "Vanilla Almond Butter Protein Granola", "type": "Gain Muscles", "fats":"4g","carbs":"27g","sugar":"0g","salt":"0g","protein":"6g"})


    print("Database sucessfully restarted to default")




while True:
    print("------MENU------")
    print("1. Add a new Recipe")
    print("2. Remove a particular Recipe")
    print("3. Reset Database")
    print("4. Exit")
    print()
    option = int(input("Choose an option:"))
    if option == 1:
        AddRecipe()
        
    elif option == 2:
        RemoveRecipe()
      
    elif option == 3:
        ResetDatabase()
        
    elif option ==4:
        break

    print()
 
