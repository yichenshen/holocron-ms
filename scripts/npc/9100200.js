var status = -1

function start() {
  action(1, 0, 0)
}

function action(mode, type, selection) {
  if (mode == 1) {
    status++
  } else {
    cm.dispose()
    return
  }

  if (!cm.getPlayer().isEligibleForDailyClaim()) {
    cm.sendOk(
      "You have already claimed your daily reward today. Please come back tomorrow!",
    )
    cm.dispose()
    return
  }

  if (status == 0) {
    cm.sendYesNo(
      "Would you like to claim your daily reward? You can claim #b10,000 NX#k and #b1 Perfect Pitch#k once every day.",
    )
  } else if (status == 1) {
    var nxAmount = 10000
    var itemID = 4310000
    var quantity = 1

    cm.gainNx(nxAmount)
    cm.gainItem(itemID, quantity)

    cm.getPlayer().updateDailyClaimTime()

    cm.sendOk("You have received 10,000 NX and 1x Perfect Pitch.")
    cm.dispose()
  }
}
