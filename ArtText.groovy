import com.neuronrobotics.bowlerstudio.BowlerStudioController

import eu.mihosoft.vrl.v3d.*

def piece = "mechEng"

def font = "FreeSerif"
def size_pts = 8
def depth = 5 

def spacing = 2

def size_in = size_pts / 72
def size_mm = size_in * 25.4
def spacing_mm = size_mm * 1.3 * 2

def AAS_string = "Courtesy, American Antiquarian Society"
CSG AAS_credit = CSG.text(AAS_string,depth, size_pts, font)

WorcFreeInst_string = "Worcester Free Institute Buildings & Rooms, 1880"
CSG WorcFreeInst = CSG.text(WorcFreeInst_string, depth, size_pts, font).movey(spacing_mm)

mechEng_string = "Mechanical Engineers, workers of the world"
CSG mechEng = CSG.text(mechEng_string, depth, size_pts, font).movey(spacing_mm*2)

//if piece = ""
CSG ret = AAS_credit.union(WorcFreeInst).union(mechEng)

//BowlerStudioController.addCsg(ret)

ret = ret.mirrorx()

ret = ret.setColor(javafx.scene.paint.Color.DARKRED)
			.setName(piece)
			.addAssemblyStep(0, new Transform().movez(5))
			.setManufacturing({ toMfg ->
				return toMfg
						//.rotx(180)// fix the orientation
						//.toZMin()//move it down to the flat surface
			})

println javafx.scene.text.Font.getFontNames()

return ret