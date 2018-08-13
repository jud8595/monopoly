# monopoly
# Considération de design:
# ** Commit 6d968a2 on action-do-not-break-interface
# Soit on passe à la méthode Action.execute le contexte en cours d'exécution (ex: Action.execute(MonoContext)).
# Soit on ne veut passer que les éléments dont Action.execute a besoin et on implémente des interfaces avec les éléments demandés + boucle sur le type d'interface dans Mono.
# Autre solution: on peut aussi passer une Map pour la 1ere solution au lieu de passer un nouvel objet archaïque MonoContext, ou pour la 2ème solution si un objet implémente plusieurs interfaces et qu'on ne veut pas créer de nouvelle interface du type ActionNeedAandActionNeedB
# La 2e solution est peut-être meilleure. On sait quel élément sont utilisés par qui et on n'a pas d'objet fourre-tout. Potentiellement, imaginons qu'une des actions ait besoin de la date d'anniversaire d'un des participants ou d'une grosse quantité de données, on ne veut pas passer ça aux autres actions.