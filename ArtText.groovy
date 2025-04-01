import com.neuronrobotics.bowlerstudio.BowlerStudioController

import eu.mihosoft.vrl.v3d.*

def name
def print_fonts
if(args==null){
	//name = "mechEng"
	//name = "ubiwerks"
	name = "fight"
	println "No parameters found. Using name = "+name
	print_fonts = true
} else {
	name = args.get(0)
	println "Piece name sent to description text constructor: "+name
	print_fonts = false
}

def font = "TeX Gyre Schola Bold"
def size_pts = 8
def depth = 0.4

def spacing = 2

def size_in = size_pts / 72
def size_mm = size_in * 25.4
def spacing_mm = size_mm * 1.3 * 2.7
//println spacing_mm

def mechEng_string = "Mechanical Engineers, workers of Worcester"
def boynton_string = "Boynton Hall and surroundings"
def WorcFreeInst_string = "Worcester Free Institute Buildings & Rooms, 1880"
def trotting_string = "Trotting cracks on the snow, by Louis Maurer"
def regatta_string = "Worcester's Regatta Roots"
def CurrierIves_1853_string = "Published by Currier & Ives, 1853"
def LakeQuinsigamond_1868_string = "Lake Quinsigamond, 1868"
def celebrating_string = "Celebrating history and community spirit"
def harr_string = "The Harrington Brothers Three"
//def harr_att_string = "Photograph by Andrew Harrington"
//def celebrating_string = "Preserving a moment in time from Worcester's past"
//def willie_string =   "Steamboat Willie, 1928"
//def ubiwerks_string = "       by Ub Iwerks, 1901–1971"
def willie_string =   "From Steamboat Willie, 1928"
def ubiwerks_string = "By Ub Iwerks, 1901–1971"
def AAS_string = "Courtesy, American Antiquarian Society"
def WHM_string = "Courtesy, Worcester Historical Museum"
def PDR_string = "Courtesy, The Public Domain Review"

ArrayList<Object> icon_params = new ArrayList<Object>();
icon_params.add(depth) //add

def firstLine_string, secondLine_string, thirdLine_string, fourthLine_string, fifthLine_string, sixthLine_string, seventhLine_string
CSG firstLine, secondLine, thirdLine, fourthLine, fifthLine, sixthLine, seventhLine
switch (name) {
	case "mechEng":
		firstLine_string = AAS_string
		secondLine_string = WorcFreeInst_string
		thirdLine_string = mechEng_string
		break
	case "boynton":
		firstLine_string = AAS_string
		secondLine_string = WorcFreeInst_string
		thirdLine_string = boynton_string
		break
	case "trotting":
		firstLine_string = AAS_string
		secondLine_string = CurrierIves_1853_string
		thirdLine_string = trotting_string
		break
	case "regatta":
		firstLine_string = WHM_string
		secondLine_string = celebrating_string
		thirdLine_string = LakeQuinsigamond_1868_string
		fourthLine_string = regatta_string
		break
	case "ubiwerks":
		//firstLine_string = " " 
		thirdLine_string = PDR_string
		fourthLine_string = ubiwerks_string
		fifthLine_string = willie_string
		sixthLine = (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
		                            "publicdomainiconextrusion.groovy" , // file to load
		                            icon_params// no parameters (see next tutorial)
                        			)
		break
	case "harrington":
		secondLine = (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
		                            "publicdomainiconextrusion.groovy" , // file to load
		                            icon_params// no parameters (see next tutorial)
                        			)
		thirdLine_string = "2024"
		fourthLine_string = harr_string
		
		break
	case "stebbins":
		firstLine_string = AAS_string
		secondLine = (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
		                            "publicdomainiconextrusion.groovy" , // file to load
		                            icon_params// no parameters (see next tutorial)
                        			)
		thirdLine_string = "1833"
		fourthLine_string = "Stebbins"
		break
	case "fight":
		fifthLine_string = "Fight"
		fourthLine_string = "Butler, Pennsylvania"
		thirdLine_string = "July 13, 2024"
		secondLine = (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
		                            "publicdomainiconextrusion.groovy" , // file to load
		                            icon_params// no parameters (see next tutorial)
                        			)
		break
	case "jankal":
		//sixthLine_string = 
		fifthLine_string = "Memories of Kaua'i"
		fourthLine_string = "Danyel & Jansen"
		thirdLine_string = "March 31, 2023"
		secondLine = (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
		                            "publicdomainiconextrusion.groovy" , // file to load
		                            icon_params// no parameters (see next tutorial)
                        			)
		break
	case "toussaint":
		fifthLine_string = "Revolutionary Red"
		fourthLine_string = "Toussaint L'Ouverture"
		thirdLine_string = "By George DeBaptiste, 1870"
		secondLine = (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
		                            "publicdomainiconextrusion.groovy" , // file to load
		                            icon_params// no parameters (see next tutorial)
                        			)
		break
	case "depose":
		fifthLine_string = "DENY - DEFEND - DEPOSE"
		fourthLine_string = "By Spade.Ink"
		thirdLine_string = "Courtesy, Punk With A Camera"
		secondLine = (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
		                            "publicdomainiconextrusion.groovy" , // file to load
		                            icon_params// no parameters (see next tutorial)
                        			)
		break
	case "anmol":
		seventhLine_string = "Grow with each other &"
		sixthLine_string = "Make memories"
		fourthLine_string = "Anmol & Dhruv"
		thirdLine_string = "22 January, 2025"
//		secondLine = (CSG)ScriptingEngine.gitScriptRun(
//	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git", // git location of the library
//		                            "publicdomainiconextrusion.groovy" , // file to load
//		                            icon_params// no parameters (see next tutorial)
//                        			)
		break
	default:
		throw new Exception("Unknown option: $name")
		break
}

CSG ret
if (firstLine) {
    ret = firstLine
} else if (firstLine_string) {
    firstLine = CSG.text(firstLine_string, depth, size_pts, font)
    ret = firstLine
}

if (secondLine) {
    secondLine = secondLine.movey(spacing_mm)
} else if (secondLine_string) {
    secondLine = CSG.text(secondLine_string, depth, size_pts, font)
	secondLine = secondLine.movey(spacing_mm)
}
if (ret && secondLine) {
	ret = ret.union(secondLine)
} else if (secondLine) {
	ret = secondLine
}

if (thirdLine) {
    thirdLine = thirdLine.movey(spacing_mm*2)
} else if (thirdLine_string) {
    thirdLine = CSG.text(thirdLine_string, depth, size_pts, font)
	thirdLine = thirdLine.movey(spacing_mm*2)
}
if (ret && thirdLine) {
	ret = ret.union(thirdLine)
} else if (thirdLine) {
	ret = thirdLine
}

if (fourthLine) {
    fourthLine = fourthLine.movey(spacing_mm*3)
} else if (fourthLine_string) {
    fourthLine = CSG.text(fourthLine_string, depth, size_pts, font)
	fourthLine = fourthLine.movey(spacing_mm*3)
}
if (ret && fourthLine) {
	ret = ret.union(fourthLine)
} else if (fourthLine) {
	ret = (fourthLine)
}

if (fifthLine) {
	fifthLine = fifthLine.movey(spacing_mm*4)
} else if (fifthLine_string) {
	fifthLine = CSG.text(fifthLine_string, depth, size_pts, font)
	fifthLine = fifthLine.movey(spacing_mm*4)
}
if (ret && fifthLine) {
	ret = ret.union(fifthLine)
} else if (fifthLine) {
	ret = fifthLine
}

if (sixthLine) {
	sixthLine = sixthLine.movey(spacing_mm*5)
} else if (sixthLine_string) {
	sixthLine = CSG.text(sixthLine_string, depth, size_pts, font)
	sixthLine = sixthLine.movey(spacing_mm*5)
}
if (ret && sixthLine) {
	ret = ret.union(sixthLine)
} else if (sixthLine) {
	ret = sixthLine
}

if (seventhLine) {
	seventhLine = seventhLine.movey(spacing_mm*6)
} else if (seventhLine_string) {
	seventhLine = CSG.text(seventhLine_string, depth, size_pts, font)
	seventhLine = seventhLine.movey(spacing_mm*6)
}
if (ret && seventhLine) {
	ret = ret.union(seventhLine)
} else if (seventhLine) {
	ret = seventhLine
}


ret = ret.movex(12).movey(15)
//ret = ret.mirrorx()

ret = ret.setColor(javafx.scene.paint.Color.PINK)
			.setName(name+"_desc_raw")
			.addAssemblyStep(0, new Transform())
			.setManufacturing({ toMfg ->
				return toMfg
						//.rotx(180)// fix the orientation
						//.toZMin()//move it down to the flat surface
			})

//if (print_fonts){
//	def fonts = javafx.scene.text.Font.getFontNames()
//	println fonts.size()
//}
			
if (print_fonts) {
	def fonts = javafx.scene.text.Font.getFontNames()
	def fontIndex = 0
	while (fontIndex < fonts.size()) {
	    def endFont = Math.min(fontIndex + 100, fonts.size())
	    def chunk = fonts.subList(fontIndex, endFont)
	    println "Fonts ${fontIndex+1} to $endFont:"
	    chunk.each { fontName -> println fontName }
	    Thread.sleep(100) // pause for 0.1 seconds
	    fontIndex += 100
	}
}

return ret