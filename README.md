### Parse Trello Json in Kotlin

#### Background
I Needed a way to migrate my Trello boards to a different platform. 
The only export option Trello offers is massive json file. 
Since my new platform doesn't offer a direct import of this format, 
had to write a small Kotlin program that parses the file and print out 
the cards, their description, and a few other pieces of metadata to the console.

This program is *very basic*, as it is set up to to work for my simple needs.  

Feel free to fork and customize to meet your needs. 

#### Usage
```bash 
gradle run --args="<path-to-trello-exported.json>"
```    
