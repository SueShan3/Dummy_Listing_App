package com.example.dummylistingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dummylistingapp.adapter.RecyclerAdapter
import com.example.dummylistingapp.model.Item

class ListFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = ArrayList<Item>()

        //hardcode data
        itemList.add(
            Item(
                "The Lady and the Tramp",
                "Integer congue neque eu turpis fringilla venenatis.",
                "https://media.timeout.com/images/105509877/1024/768/image.jpg",
                "Our band of film critics named Pinocchio the best animated film of all " +
                        "time, but you don’t need to be a historian to see why the tale of the " +
                        "little wooden boy seeking to become real is the high water mark for " +
                        "Disney. From the puppet’s ever-growing nose to the climax within a " +
                        "whale, the Blue Fairy to Jiminy Cricket singing ‘when you wish upon a " +
                        "star,’ nearly every minute is iconic and awe-inspiring."
            )
        )
        itemList.add(
            Item(
                "Peter Pan",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "https://media.timeout.com/images/105526885/1024/768/image.jpg",
                "Mr. Incredible and Elastigirl are forced to play it cool when the " +
                        "government forbids super-hero activity. Although they should take an " +
                        "opportunity to catch up on some r&r during the hiatus, they can't help " +
                        "but miss stopping crime. Soon enough, their efforts are needed once " +
                        "again. This is top-tier superhero stuff that stands tall alongside " +
                        "Marvel and DC’s best."
            )
        )
        itemList.add(
            Item(
                "The Incredibles",
                "Nulla molestie lacus imperdiet, ultricies urna id, porta augue.",
                "https://media.timeout.com/images/105509856/1024/768/image.jpg",
                "Dumbo's certainly the most eccentric part of the circus. The poor " +
                        "elephant with gigantic ears is the target of much ridicule, which makes " +
                        "things even more grueling during the circus. However, the joke's on " +
                        "everyone else when Dumbo learns his ears allow him to fly! Expect to " +
                        "shed a few tears with this one."
            )
        )
        itemList.add(
            Item(
                "Dumbo",
                "Duis sagittis nisi vel ipsum imperdiet rhoncus.",
                "https://media.timeout.com/images/105526894/1024/768/image.jpg",
                "Disney’s first animated feature completely changed the face of cinema, " +
                        "but even in the age of eye-popping computer animation, it remains a " +
                        "stunning achievement. It's also equal parts thrilling, scary, funny and " +
                        "whimsical. Few films hold up as well as Snow White, and decades’s worth " +
                        "of ho-hum remakes, reimaginations and adaptations only prove how " +
                        "impressive Disney's achievement really is."
            )
        )
        itemList.add(
            Item(
                "Snow White",
                "Praesent non ex non turpis hendrerit facilisis volutpat eu nunc.",
                "https://media.timeout.com/images/105526895/1024/768/image.jpg",
                "The rat can cook! This sweetly ridiculous movie about a naive, ambitious" +
                        " rodent named Remy (charmingly voiced by Patton Oswalt), who longs to " +
                        "become a great chef is witty, clever, gently moral and dramatically " +
                        "convincing. Who doesn't love Linguini (voiced by Lou Romano), a hopeless" +
                        " human moppet controlled by the supremely talented Remy? Will they win " +
                        "over the Snow White-style villain, a power-crazed food critic named " +
                        "Anton Ego. We won't spoil the fun for the three of you out there who " +
                        "don't yet know the ending of this unexpectedly delightul Pixar masterwork."
            )
        )
        itemList.add(
            Item(
                "Ratatouille",
                "Curabitur at urna ut eros fringilla semper a non magna.",
                "https://media.timeout.com/images/101526981/1024/768/image.jpg",
                "Iconic villain Cruella De Vil got some image rehabilitation thanks to " +
                        "Emma Stone, but in this original feature she makes good on her name as " +
                        "she obsesses over making coats out of Pongo and Perdita's pups. The " +
                        "villains here are a riot, as are the old-timey London locales. And " +
                        "don't worry, this is a Disney film."
            )
        )
        itemList.add(
            Item(
                "Up",
                "Quisque dapibus purus non quam pharetra vestibulum.",
                "https://media.timeout.com/images/105509850/1024/768/image.jpg",
                "Up is so much more than its famous opening montage, which will leave " +
                        "even the most curmudgeonly viewer drowning in tears. It's a master " +
                        "class in emotional storytelling. But once widower Carl's house becomes " +
                        "skybound, Up transitions into a rolicking adventure, one packed with " +
                        "exotic locales, talking (and flying!) dogs, colorful birds and one very," +
                        " very dedicated boy scout. Want more once the credits roll? Disney+ " +
                        "recently released a canine-focused series of shorts called Dug Days."
            )
        )
        itemList.add(
            Item(
                "101 Dalmatians",
                "Sed placerat dui at molestie rhoncus.",
                "https://media.timeout.com/images/105526884/1024/768/image.jpg",
                "Wall-E is an ancient robot and the sole robot left on Earth. Naturally, " +
                        "being the only one of his kind isn't easy, and lonliness ensues until " +
                        "EVE arrives. With Wall-E, Pixar proved you don't need an all-star voice " +
                        "cast –or even much dialogue – to tell a moving story about lonely souls " +
                        "discovering there is warmth in even the coldest worlds. And once the " +
                        "humans do show up, Wall-E shifts to an especially zany sci-fi comedy."
            )
        )
        itemList.add(
            Item(
                "Wall-E",
                "Curabitur dapibus leo id neque dapibus pretium.",
                "https://media.timeout.com/images/105526889/1024/768/image.jpg",
                "Mowgli can't seem to find his place in this world. In Disney's " +
                        "rendition of the Rudyard Kipling story, this young orphan is set out " +
                        "on a quest to learn more about his identity, with the help of animal " +
                        "companions, all while warding off Shere Khan. "
            )
        )
        itemList.add(
            Item(
                "The Jungle Book",
                "Suspendisse tempor eros at tellus pulvinar dictum.",
                "https://media.timeout.com/images/105509862/1024/768/image.jpg",
                "A pompous prince gets a taste of his own medicine in this '90s " +
                        "fairytale from Disney's Renaissance. The first animated film to score " +
                        "an Oscar nomination for Best Picture. An enchantress' spell turns the " +
                        "royal into a ferocious beast, and it cannot be undone until he falls in " +
                        "love. When the beast kidnaps the town's clockmaster, his beautiful " +
                        "daughter comes to the rescue and the beast's, too."
            )
        )
        itemList.add(
            Item(
                "Beauty and the Beast",
                "Curabitur in libero in tellus fringilla ultrices id id est.",
                "https://media.timeout.com/images/105509866/1024/768/image.jpg",
                "Yet Pixar has continually spun gold out of its flagship toybox. The " +
                        "first Toy Sequel sequel ate – initially set to be a direct-to-video " +
                        "affair – builds upon the world of Buzz and Woody with an " +
                        "ahead-of-its-time story about obsessive fandom while simultaneously " +
                        "fine-tuning Pixar’s formula of balancing laughter and tears. Good luck " +
                        "getting through bubbly cowgirl Jessie’s existentially devastating " +
                        "origin story with a dry eye."
            )
        )
        itemList.add(
            Item(
                "Toy Story 2",
                "Aenean accumsan enim nec libero commodo, at ornare nibh pretium.",
                "https://media.timeout.com/images/101527077/1024/768/image.jpg",
                "Sequels are hard – just ask the Cars franchise. Yet Pixar has " +
                        "continually spun gold out of its flagship toybox. The first Toy Sequel " +
                        "sequel ate – initially set to be a direct-to-video affair – builds upon " +
                        "the world of Buzz and Woody with an ahead-of-its-time story about " +
                        "obsessive fandom while simultaneously fine-tuning Pixar’s formula of " +
                        "balancing laughter and tears. Good luck getting through bubbly cowgirl " +
                        "Jessie’s existentially devastating origin story with a dry eye."
            )
        )
        itemList.add(
            Item(
                "Finding Nemo",
                "Vestibulum aliquet erat non augue sodales ultrices at sed tortor.",
                "https://media.timeout.com/images/105509875/1024/768/image.jpg",
                "Like most kids, Nemo can be somewhat defiant. His father warns him to " +
                        "swim close, yet he's always in search of independence. When the little " +
                        "fish goes MIA under the sea, and encounters a great white named Bruce " +
                        "along the way, he realizes that his pop just might know a thing or two " +
                        "he doesn't! Sometimes it doesn't hurt to listen to 'ol dad. "
            )
        )
        itemList.add(
            Item(
                "Bambi ",
                "Etiam nec odio in tortor pellentesque imperdiet sit amet et nunc.",
                "https://media.timeout.com/images/105526887/1024/768/image.jpg",
                "Endearing and emotional, Bambi is the story of a super-cute deer who " +
                        "comes into his own with help of family and friends in the forest. Yes, " +
                        "the famous demise of Bambi's mom is still heartbreaking. But the " +
                        "sequences with Thumper, Flower and Bambi getting all twitterpated " +
                        "helps balance the mood nicely."
            )
        )
        itemList.add(
            Item(
                "Inside Out",
                "Pellentesque ac massa a ex dictum viverra ac sit amet dolor.",
                "https://media.timeout.com/images/105509849/1024/768/image.jpg",
                "With Inside Out, a studio famous for manipulation emotions makes an " +
                        "actual film about emotions personified. In diving into the mind of a " +
                        "tweenage girl Pixar takes what could have been a shameless attack on " +
                        "the heartstrings and emerges with a hilarious, beautiful testament to " +
                        "the things that make us human (or, at one point, cats). Don't worry " +
                        "though: Yes, you'll be crying throughout, but many of those tears will " +
                        "come from laughter too."
            )
        )
        itemList.add(
            Item(
                "Toy Story 3",
                "Proin consectetur tellus vel gravida fringilla.",
                "https://media.timeout.com/images/105782735/1024/768/image.jpg",
                "The sequels are usually never as good as the original, although that's " +
                        "not the case for the Toy Story franchise, which seems has continually " +
                        "built upon its foundation with great success. While not as existential " +
                        "as Toy Story 4, this emotional threequel up touches on what it means to " +
                        "grow up and face your own mortality. The last 15 minutes might just be " +
                        "Pixar at its most emotionally resonant... which it really, really " +
                        "saying something."
            )
        )
        itemList.add(
            Item(
                "Cinderella",
                "Mauris consequat nisl tincidunt dolor aliquam, eget tristique nunc " +
                        "gravida.",
                "https://media.timeout.com/images/101507145/1024/768/image.jpg",
                "Cinderella is probably one of the most patient Disney princesses out " +
                        "there. Despite her bad fortune, she remains hopeful, even when her " +
                        "wicked stepmom and stepsisters give her a run for her money. But the " +
                        "young woman gets the last laugh when her fairy godmother helps her " +
                        "reunite with a handsome prince at the ball. You'll replay this one " +
                        "faster than you can say ‘bibbidi-bobbidi-boo!’"
            )
        )
        itemList.add(
            Item(
                "The Little Mermaid",
                "Quisque quis dolor ullamcorper, venenatis magna ut, mollis lorem.",
                "https://media.timeout.com/images/105509852/1024/768/image.jpg",
                "It’s hard to imagine a time when Disney was in need of a ‘revival’, " +
                        "but the company’s fabled Renaissance period kicked off with this loose " +
                        "adaptation of the Hans Christian Andersen fable. Ariel is a " +
                        "starry-eyed young mermaid who enters into a Faustian bargain with an " +
                        "evil sea witch to fulfil her dream of marrying a human prince. What " +
                        "everyone remembers, though, are the songs: even if you haven’t seen " +
                        "it since the VHS era, you can still recite ‘Under the Sea’ from memory " +
                        "with 100 percent accuracy."
            )
        )
        itemList.add(
            Item(
                "The Lion King",
                "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet",
                "https://media.timeout.com/images/105281695/1024/768/image.jpg",
                "Equal parts endearing and heartbreaking, the Disney classic rotates " +
                        "around young lion Simba, who must rise to power after the loss of his " +
                        "father, Mufasa in what basically amounts to Hamlet for kids. The " +
                        "animation here is perhaps the most stunning of Disney's hand-drawn era, " +
                        "and the songs are timeless. Feel free to skip the 2019 reboot, which " +
                        "sucks all the color and expressiveness out of one of Disney's most " +
                        "vibrant tales."
            )
        )
        itemList.add(
            Item(
                "Coco",
                "Nam ac porttitor turpis non auctor nulla congue eget. ",
                "https://media.timeout.com/images/105543250/1024/768/image.jpg",
                "Like Inside Out, Coco finds Pixar flirting with emotional exploitation: " +
                        "This is, after all, a film about a kid who reconnects with his family " +
                        "roots in the Land of the Dead while chasing after a long-dead musical " +
                        "idol. Yet the film delivers a colorful, funny, touching meditation on " +
                        "Mexican culture and family legacies complete with great songs and " +
                        "fantastic beasts. No film about death has ever felt so alive."
            )
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter(context, itemList)
        }
    }
}