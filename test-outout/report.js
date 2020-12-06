$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Workspace/BlueStacks/src/main/java/Features/BlueStacks.feature");
formatter.feature({
  "line": 1,
  "name": "Find all the games and their tournament size",
  "description": "",
  "id": "find-all-the-games-and-their-tournament-size",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Find all the games and their tournament size",
  "description": "",
  "id": "find-all-the-games-and-their-tournament-size;find-all-the-games-and-their-tournament-size",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "We go to the \"https://game.tv\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "We scroll to the bottom of the page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "We get the list of the games",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "We close all chrome instances",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://game.tv",
      "offset": 14
    }
  ],
  "location": "BlueStacks.we_go_to_the(String)"
});
formatter.result({
  "duration": 39804892100,
  "status": "passed"
});
formatter.match({
  "location": "BlueStacks.we_scroll_to_the_bottom_of_the_page()"
});
formatter.result({
  "duration": 1499272400,
  "status": "passed"
});
formatter.match({
  "location": "BlueStacks.we_get_the_list_of_the_games()"
});
formatter.result({
  "duration": 786980096600,
  "status": "passed"
});
formatter.match({
  "location": "BlueStacks.we_close_all_chrome_instances()"
});
formatter.result({
  "duration": 1242040800,
  "status": "passed"
});
});