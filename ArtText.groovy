import com.neuronrobotics.bowlerstudio.BowlerStudioController

import eu.mihosoft.vrl.v3d.*

def name
def print_fonts
if(args==null){
	//name = "mechEng"
	name = "boynton"
	println "No parameters found. Using name = "+name
	print_fonts = true
} else {
	name = args.get(0)
	println "Piece name sent to description text constructor: "+name
	print_fonts = false
}

def font = "FreeSerif Bold"
def size_pts = 8
def depth = 0.4

def spacing = 2

def size_in = size_pts / 72
def size_mm = size_in * 25.4
def spacing_mm = size_mm * 1.3 * 2.4

def mechEng_string = "Mechanical Engineers, workers of Worcester"
def boynton_string = "Boynton Hall and surroundings"
def WorcFreeInst_string = "Worcester Free Institute Buildings & Rooms, 1880"
def trotting_string = "Trotting cracks on the snow, by Louis Maurer"
def regatta_string = "Worcester's Regatta Roots"
def CurrierIves_1853_string = "Published by Currier & Ives, 1853"
def LakeQuinsigamond_1868_string = "Lake Quinsigamond, 1868"
def celebrating_string = "Celebrating history and community spirit"
//def celebrating_string = "Preserving a moment in time from Worcester's past"
def willie_string = "Steamboat Willie, by Ub Iwerks"
def AAS_string = "Courtesy, American Antiquarian Society"
def WHM_string = "Courtesy, Worcester Historical Museum"
//def pubdom_string = "🅮"

def firstLine_string
def secondLine_string
def thirdLine_stringe
def fourthLine_string
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
		firstLine_string = willie_string
		//secondLine_string = pubdom_string
	default:
		throw new Exception("Unknown option: $name")
		break
}

CSG ret
CSG firstLine

firstLine = CSG.text(firstLine_string, depth, size_pts, font)
ret = firstLine


if (secondLine_string) {
	CSG secondLine = CSG.text(secondLine_string, depth, size_pts, font).movey(spacing_mm)
	ret = ret.union(secondLine)
}


if (thirdLine_string) {
	CSG thirdLine = CSG.text(thirdLine_string,depth, size_pts, font).movey(spacing_mm*2)
	ret = ret.union(thirdLine)
}

if (fourthLine_string) {
	CSG fourthLine = CSG.text(fourthLine_string, depth, size_pts, font).movey(spacing_mm*3)
	ret = ret.union(fourthLine)
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