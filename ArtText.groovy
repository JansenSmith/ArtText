import com.neuronrobotics.bowlerstudio.BowlerStudioController

import eu.mihosoft.vrl.v3d.*

def name
def print_fonts
if(args==null){
	//name = "mechEng"
	//name = "ubiwerks"
	name = "fightThem"
	println "No parameters found. Using name = "+name
	print_fonts = true
} else {
	name = args.get(0)
	println "Piece name sent to description text constructor: "+name
	print_fonts = false
}

// Font faces. Names are matched against JavaFX's own font list ignoring case, spaces
// and hyphens, so "TeX Gyre Pagella Bold" and "TeXGyrePagella-Bold" both resolve.
// JavaFX silently substitutes "System Regular" for a name it can't find, so an
// unresolvable name throws instead.
def BOLD = "TeX Gyre Pagella Bold"
def BOLD_ITALIC = "TeX Gyre Pagella Bold Italic"
def ITALIC = "TeX Gyre Pagella Italic"
def REGULAR = "TeX Gyre Pagella Regular"
def font = BOLD // default for plain-string lines
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
def NOB_string = "Courtesy, N.O. Bonzo"

ArrayList<Object> icon_params = new ArrayList<Object>();
icon_params.add(depth) //add

def pdIcon = { ->
	return (CSG)ScriptingEngine.gitScriptRun(
	                                "https://github.com/JansenSmith/publicdomainiconextrusion.git",
		                            "publicdomainiconextrusion.groovy",
		                            icon_params
                        			)
}

// Lines, keyed by line number: line 1 sits at the bottom, each line above it one
// spacing_mm higher. Unused numbers leave a blank line. A line is one of:
//   "text"                              — set in the default font
//   pdIcon()                            — any CSG, placed as-is
//   [seg, seg, ...]                     — segments laid left to right, each one:
//        "text" | [text: "...", font: ITALIC] | pdIcon()
//     a CSG segment is centered on the cap height of the text before it.
def lines = [:]
switch (name) {
	case "mechEng":
		lines[1] = AAS_string
		lines[2] = WorcFreeInst_string
		lines[3] = mechEng_string
		break
	case "boynton":
		lines[1] = AAS_string
		lines[2] = WorcFreeInst_string
		lines[3] = boynton_string
		break
	case "trotting":
		lines[7] = "Trotting cracks on the snow, 2026"
		lines[6] = CurrierIves_1853_string
		lines[5] = "Lithograph by Louis Maurer, 1832–1932"
		lines[4] = AAS_string
		lines[3] = pdIcon()
		break
	case "regatta":
		lines[1] = pdIcon()
		lines[2] = WHM_string
		lines[3] = celebrating_string
		lines[4] = LakeQuinsigamond_1868_string
		lines[5] = regatta_string
		break
	case "regatta_triangles":
		// Study piece: every Pagella face, a mixed-face line, the PD icon inline.
		// Upper block is my piece; lower block is the source.
		lines[8] = [[text: "Worcester's Regatta Roots, 2026", font: BOLD_ITALIC], pdIcon()]
		lines[7] = [[text: "By", font: REGULAR], [text: "Jansen Smith", font: BOLD]]
		lines[6] = [[text: "Stamped in triangles", font: ITALIC]]
		lines[5] = [[text: "Layered in PLA", font: ITALIC]]
		lines[3] = [[text: "The College Regatta at Worcester, 1868", font: ITALIC]]
		lines[2] = [[text: "Sketch by C.E.H. Bonwill, b. ca. 1836", font: REGULAR]]
		lines[1] = [[text: WHM_string, font: REGULAR]]
		break
	case "ubiwerks":
		lines[3] = PDR_string
		lines[4] = ubiwerks_string
		lines[5] = willie_string
		lines[6] = pdIcon()
		break
	case "harrington":
		lines[2] = pdIcon()
		lines[3] = "2024"
		lines[4] = harr_string
		break
	case "stebbins":
		lines[1] = AAS_string
		lines[2] = pdIcon()
		lines[3] = "1833"
		lines[4] = "Stebbins"
		break
	case "fightThem":
		lines[5] = "Fight"
		lines[4] = "Butler, Pennsylvania"
		lines[3] = "July 13, 2024"
		lines[2] = pdIcon()
		break
	case "jankal":
		lines[5] = "Memories of Kaua'i"
		lines[4] = "Danyel & Jansen"
		lines[3] = "March 31, 2023"
		lines[2] = pdIcon()
		break
	case "toussaint":
		lines[5] = "Revolutionary Red"
		lines[4] = "Toussaint L'Ouverture"
		lines[3] = "By George DeBaptiste, 1870"
		lines[2] = pdIcon()
		break
	case "depose":
		lines[5] = "DENY - DEFEND - DEPOSE"
		lines[4] = "By Spade.Ink"
		lines[3] = "Courtesy, Punk With A Camera"
		lines[2] = pdIcon()
		break
	case "gigi_tal":
		lines[6] = "Partners in Crime, 2025"
		lines[5] = "Gigi & Cousin Tal"
		lines[4] = "We hope to look as Fine..."
		lines[3] = "Jansen & Danyel"
		break
	case "anmol":
		lines[7] = "Grow with each other &"
		lines[6] = "Make memories"
		lines[4] = "Anmol & Dhruv"
		lines[3] = "22 January, 2025"
		break
	case "wolves":
		lines[6] = "Keeping the Wolves at Bay, 2026"
		lines[5] = "In Memory of Keith Haring, 1958–1990"
		lines[4] = pdIcon()
		break
	case "solidarityForever":
		lines[6] = "Solidarity Forever"
		lines[5] = "May Day"
		lines[4] = NOB_string
		lines[3] = pdIcon()
		break
	case "solidarityForever_isabel":
		lines[6] = "May Day, Isabel's Day"
		lines[5] = "This Year and Every Year"
		lines[4] = "Solidarity Forever"
		lines[3] = NOB_string
		break
	case "separation":
		lines[7] = "Separation, 2026"
		lines[6] = "Adskillelse"
		lines[5] = "Åsgårdstrand, Norway, 1896"
		lines[4] = "Edvard Munch, 1863–1944"
		lines[3] = pdIcon()
		break
	case "horsesDontKnow_union":
		lines[7] = "The Horses Don't Know, 2026"
		lines[6] = "\"New\" Union Station, ca. 1915"
		lines[5] = "Photography by E.B. Luce, 1864–1938"
		lines[4] = "Courtesy, Worcester Historical Museum"
		lines[3] = pdIcon()
		break
	case "bisonCouche":
		lines[7] = "A Bison Couchant, 2026"
		lines[6] = "Courtesy, an unnamed human artist"
		lines[5] = "From Altamira ceiling, Cantabria"
		lines[4] = "c. 9,000 years before writing"
		lines[3] = "After Henri Breuil, 1906"
		lines[2] = pdIcon()
		break
	default:
		throw new Exception("Unknown option: $name")
		break
}

def fontNames = javafx.scene.text.Font.getFontNames()
def fontKey = { String s -> s.toLowerCase().replaceAll(/[^a-z0-9]/, "") }
def resolveFont = { String want ->
	// try the name as written, then any listed name that matches it; keep the first
	// one JavaFX actually loads (a miss comes back as "System Regular")
	def candidates = [want] + fontNames.findAll { fontKey(it) == fontKey(want) }
	def hit = candidates.find { fontKey(new javafx.scene.text.Font(it, size_pts).getName()) == fontKey(want) }
	if (hit == null)
		throw new Exception("ArtText: JavaFX can't load font '${want}' (tried ${candidates}); refusing to fall back to System Regular")
	// hand CSG.text JavaFX's own spelling so its name check passes (no font-list dump)
	return new javafx.scene.text.Font(hit, size_pts).getName()
}

def text = { String s, String face ->
	return CSG.text(s, depth, size_pts, resolveFont(face))
}

// segments of a composed line sit one word space apart, measured from the face itself
def spaceWidth = { String face ->
	return text("n n", face).getTotalX() - text("nn", face).getTotalX()
}

def renderLine = { spec ->
	if (spec instanceof CSG)
		return spec
	if (!(spec instanceof List))
		return text(spec.toString(), font)
	CSG row = null
	String lastFace = font
	spec.each { seg ->
		CSG part
		if (seg instanceof CSG) {
			part = seg
			// center on the cap height of the preceding face ("H" spans baseline to cap)
			CSG cap = text("H", lastFace)
			def capMid = (cap.getMinY() + cap.getMaxY()) / 2
			part = part.movey(capMid - (part.getMinY() + part.getMaxY()) / 2)
		} else if (seg instanceof Map) {
			lastFace = seg.font ?: font
			part = text(seg.text, lastFace)
		} else {
			lastFace = font
			part = text(seg.toString(), font)
		}
		if (row == null) {
			row = part
		} else {
			part = part.movex(row.getMaxX() + spaceWidth(lastFace) - part.getMinX())
			row = row.union(part)
		}
	}
	return row
}

CSG ret
lines.keySet().sort().each { int n ->
	CSG line = renderLine(lines[n])
	if (n > 1)
		line = line.movey(spacing_mm*(n-1))
	ret = ret ? ret.union(line) : line
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
